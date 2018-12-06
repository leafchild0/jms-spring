package com.leafchild0;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * App that actually sends a message to subscribers (publisher)
 * @author victor
 * @date 10/23/18
 */
@SpringBootApplication
public class PublisherApplicationJMS {

	static final String TOPIC_EXCHANGE_NAME = "spring-exchange";
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

	public static void main(String[] args) {

		SpringApplication.run(PublisherApplicationJMS.class, args);
	}

}
