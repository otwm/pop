package www.pop.web.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EchoController {
	@MessageMapping("/echo")
	@SendTo("/subscribe/echo")
	public String sendEcho() throws Exception {
		System.out.println("receive message : " + "");
		return "111111111111111";
	}
	
	@MessageMapping("/test")
	@SendTo("/subscribe/test")
	public String sendTest(String test) throws Exception {
		System.out.println("receive message : " + test);
		return "test : " + test;
	}
}