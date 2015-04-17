package www.pop.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.session.web.socket.handler.WebSocketRegistryListener;
import org.springframework.stereotype.Controller;

import www.pop.core.models.entities.User;

@Controller
@MessageMapping("/users")
public class UserController {
	
	@MessageMapping
	public List<User> list() {
		WebSocketRegistryListener aa;
		List<User> result = getTestUser();
		return result;
	}

	private List<User> getTestUser() {
		List<User> result = new ArrayList<User>();
		User user = new User();
		user.setId(1L);
		user.setName("testUser");
		result.add(user);
		return result;
	}
}
