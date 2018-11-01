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

	@Bean
	internal fun queue(): Queue {

		return Queue(QUEUE_NAME, false)
	}

	@Bean
	internal fun exchange(): TopicExchange {

		return TopicExchange(TOPIC_EXCHANGE_NAME)
	}

	@Bean
	internal fun binding(queue: Queue, exchange: TopicExchange): Binding {

		return BindingBuilder.bind(queue).to(exchange).with("com.leafchild0.#")
	}

	@Bean
	internal fun container(connectionFactory: ConnectionFactory,
			listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {

		val container = SimpleMessageListenerContainer()
		container.connectionFactory = connectionFactory
		container.setQueueNames(QUEUE_NAME)
		container.setMessageListener(listenerAdapter)
		return container
	}

	@Bean
	internal fun listenerAdapter(receiver: WebReceiver): MessageListenerAdapter {

		return MessageListenerAdapter(receiver, "receiveMessage")
	}

	companion object {

		internal const val TOPIC_EXCHANGE_NAME = "spring-exchange"
		private const val QUEUE_NAME = "spring-jms"

		@JvmStatic
		fun main(args: Array<String>) {

			SpringApplication.run(SubscriberWebApplication::class.java, *args)
		}
	}
}
