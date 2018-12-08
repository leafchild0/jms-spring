package com.leafchild0.vaadinjms

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

/**
 * Subscriber with Vaadin inside which will simply display new messages
 */
@SpringBootApplication
class SubscriberWebApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {

			SpringApplication.run(SubscriberWebApplication::class.java, *args)
		}
	}
}
