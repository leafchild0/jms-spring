package com.leafchild0.vaadinjms

import org.springframework.stereotype.Component

/**
 * @author victor
 * @date 10/29/18
 */
@Component
class WebReceiver {

	var listener: MessageListener? = null

	fun receiveMessage(message: String) {

		println("Received message: $message")
		listener?.onNewMessage(message)
	}

}

interface MessageListener {
	fun onNewMessage(newMessage: String)
}

