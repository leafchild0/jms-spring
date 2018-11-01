package com.leafchild0.vaadinjms

import com.vaadin.flow.component.Tag
import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Span
import com.vaadin.flow.component.page.Push
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouterLayout
import org.springframework.beans.factory.annotation.Autowired

/**
 * @author victor
 * @date 10/25/18
 */
@Route(value = "")
@HtmlImport("frontend://styles/shared-styles.html")
@PageTitle("Web Layout")
@Tag("web-layout")
@Push
class WebLayout constructor(@Autowired receiver: WebReceiver): Div(), RouterLayout, MessageListener {

	private var mainContent:Div = Div()

	/**
	 * New instance
	 */
	init {

		receiver.listener = this
		val title = H2("RabbitMQ Web Listener")
		title.addClassName("main-layout__title")
		mainContent.add(title)

		mainContent.addClassName("main-layout__header")
		add(mainContent)

		addClassName("main-layout")
	}

	override fun onNewMessage(newMessage: String) {

		ui.get().access {
			val newLabel = Div(Span(newMessage))
			mainContent.add(newLabel)
		}
	}
}
