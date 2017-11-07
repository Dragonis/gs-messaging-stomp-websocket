package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

	
    //@GetMapping("app1") //get data from outside to localhost:8080/server/user
    @MessageMapping("/app/index1")
	@SendTo("/topic/greetings") // and prepared data send back to client
    public WebSocketMessage app1(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        return message;
    }
    
    //@GetMapping("app2") //get data from outside to localhost:8080/server/user
    @MessageMapping("/app/index2")
	@SendTo("/topic/greetings")// and prepared data send back to client
    public WebSocketMessage app2(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
    	return message;
    }

}
