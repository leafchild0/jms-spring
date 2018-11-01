package com.leafchild0.jms

import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.time.LocalDate
import javax.persistence.Entity

/**
 * @author victor
 * @date 10/29/18
 */

@Entity
class Message(body: String, createdDate: LocalDate = LocalDate.now()) {

	@Id
	@GeneratedValue
	private val id: Long = 0
	private var body: String? = body
	private var createdDate: LocalDate? = createdDate

}
