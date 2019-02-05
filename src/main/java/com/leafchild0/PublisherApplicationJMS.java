package com.leafchild0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
