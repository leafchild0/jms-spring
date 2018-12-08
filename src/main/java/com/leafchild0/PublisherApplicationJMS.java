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

	public static void main(String[] args) {

		SpringApplication.run(PublisherApplicationJMS.class, args);
	}

}
