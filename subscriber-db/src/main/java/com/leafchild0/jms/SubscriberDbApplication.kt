package com.leafchild0.jms

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * App that actually send a message to a change and display it in
 * @author victor
 * @date 10/23/18
 */
@SpringBootApplication
class SubscriberDbApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {

			SpringApplication.run(SubscriberDbApplication::class.java, *args)
		}
	}

}
