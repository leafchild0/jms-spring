package com.leafchild0.jms

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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * App that actually send a message to a change and display it in
 * @author victor
 * @date 10/23/18
 */
@SpringBootApplication
@EnableJpaRepositories
class SubscriberDbApplication {

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
	internal fun listenerAdapter(receiver: SimpleReceiver): MessageListenerAdapter {

		return MessageListenerAdapter(receiver, "receiveMessage")
	}

	companion object {

		internal const val TOPIC_EXCHANGE_NAME = "spring-exchange"
		private const val QUEUE_NAME = "spring-jms"

		@JvmStatic
		fun main(args: Array<String>) {

			SpringApplication.run(SubscriberDbApplication::class.java, *args)
		}
	}

}
