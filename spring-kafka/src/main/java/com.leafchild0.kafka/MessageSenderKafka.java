package com.leafchild0.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.leafchild0.kafka.KafkaConfig.GROUP_ID;

/**
 * @author victor
 * @date 2018-11-26
 */

@Component
public class MessageSenderKafka {

	@Autowired
	protected KafkaTemplate<String, String> producer;

	void sendMessage(String message) {
		producer.send(GROUP_ID, message);
	}
}
