package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsocketController {

	
    //@GetMapping("app1") //get data from outside to localhost:8080/server/user
    @SendTo("app1") // and prepared data send back to client
    public WebSocketMessage app1(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        return message;
    }
    
    //@GetMapping("app2") //get data from outside to localhost:8080/server/user
    @SendTo("app2") // and prepared data send back to client
    public WebSocketMessage app2(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
    	return message;
    }

}
