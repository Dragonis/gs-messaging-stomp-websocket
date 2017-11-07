package hello;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/")
@RestController
public class WebsocketController {

	
    private String resourcePath = "./src/main/resources/ngapp/src/assets/i18n/";

	//@GetMapping("websocket") //get data from outside to localhost:8080/server/user
    @MessageMapping("")
    @SendTo("app1") // and prepared data send back to client
    public WebSocketMessage app1(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
    	try {
            // Serialize Java object info JSON file.
    		System.out.println("app1: test");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(resourcePath+"app1.txt"), message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
    
    //@GetMapping("app2") //get data from outside to localhost:8080/server/user
    @SendTo("app2") // and prepared data send back to client
    public WebSocketMessage app2(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
    	return message;
    }

    //http://localhost:4205/assets/i18n/pl.json
    @GetMapping("/assets/i18n/pl.json")
    public String pl_i18n(){
    	String output = "";
    	try {
			output = new String(Files.readAllBytes(Paths.get(resourcePath + "pl.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;    
	}
    
    @GetMapping("/assets/i18n/en.json")
    public String en_i18n(){
    	String output = "";
    	try {
			output = new String(Files.readAllBytes(Paths.get(resourcePath  + "en.json")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;    
	}
    
}
