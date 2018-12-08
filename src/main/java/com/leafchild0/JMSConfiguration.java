package com.leafchild0;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author victor
 * @date 2018-12-08
 */

@Configuration
public class JMSConfiguration {

	private static final String TOPIC_EXCHANGE_NAME = "spring-exchange";
	private static final String QUEUE_NAME = "spring-jms";

	@Bean
	Queue queue() {

		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {

		return new TopicExchange(TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {

		return BindingBuilder.bind(queue).to(exchange).with("com.leafchild0.#");
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {

		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		return container;
	}
}
