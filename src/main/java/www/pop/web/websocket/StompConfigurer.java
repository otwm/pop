package www.pop.web.websocket;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import www.pop.web.websocket.intercepter.HttpSessionIdHandshakeInterceptor;

/**
 * Stomp 설정
 * 
 * @author kdo
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class StompConfigurer extends AbstractWebSocketMessageBrokerConfigurer {
	@Autowired
	SessionRepository sessionRepository;

	private static final String SESSION_ATTR = "mySessionId";

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/endpoint").withSockJS()
				.setInterceptors(new HttpSessionIdHandshakeInterceptor());
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		registry.enableSimpleBroker("/topic");
	}

	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.setInterceptors(sessionContextChannelInterceptorAdapter());
	}

	@Bean
	public ChannelInterceptorAdapter sessionContextChannelInterceptorAdapter() {
		return new ChannelInterceptorAdapter() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				Map<String, Object> sessionHeaders = SimpMessageHeaderAccessor
						.getSessionAttributes(message.getHeaders());
				String sessionId = (String) sessionHeaders.get(SESSION_ATTR);
				if (sessionId != null) {
					Session session = sessionRepository.getSession(sessionId);
					if (session != null) {

						sessionRepository.save(session);
					}
				}
				return super.preSend(message, channel);
			}
		};
	}

}