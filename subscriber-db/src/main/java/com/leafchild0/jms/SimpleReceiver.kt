package com.leafchild0.jms

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * @author victor
 * @date 10/23/18
 */

@Component
class SimpleReceiver {

	@Autowired lateinit var repository: MessageRepository

	fun receiveMessage(message: String) {

		println("Received <$message>")
		repository.save(Message(message))
	}
}
