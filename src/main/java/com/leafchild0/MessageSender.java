package com.leafchild0;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author victor
 * @date 10/23/18
 */
@Component
public class MessageSender  {

	private final RabbitTemplate rabbitTemplate;

	public MessageSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	void sendMessage(String message) {

		rabbitTemplate.convertAndSend(JMSConfiguration.TOPIC_EXCHANGE_NAME, "com.leafchild0.message", message);
	}

}
