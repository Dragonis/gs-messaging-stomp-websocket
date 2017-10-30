package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
public class WebsocketController {

	
    @MessageMapping("/sendResponseTo/app1") //get data from outside to localhost:8080/server/user
    @SendTo("app1") // and prepared data send back to client
    public Greeting app1(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        return new Greeting("App1: " + message.getName() + "!");
    }
    
    @MessageMapping("/sendResponseTo/app2") //get data from outside to localhost:8080/server/user
    @SendTo("app2") // and prepared data send back to client
    public Greeting app2(WebSocketMessage message) throws Exception {
        //Thread.sleep(1000); // simulated delay
        return new Greeting("App2: " + message.getName() + "!");
    }

}
