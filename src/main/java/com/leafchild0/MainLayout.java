package com.leafchild0;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author victor
 * @date 10/25/18
 */
@Route
@HtmlImport("frontend://styles/shared-styles.html")
@PageTitle("Main Layout")
@Tag("main-layout")
public class MainLayout extends Div implements RouterLayout {

	@Autowired private MessageSender sender;

	/**
	 * New instance
	 */
	public MainLayout() {

		H2 title = new H2("RabbitMQ Publisher");
		title.addClassName("main-layout__title");
		Div mainContent = new Div();

		TextField message = new TextField("Type new message");
		Button addButton = new Button("Add");
		addButton.addClickListener(e -> {
			sender.sendMessage(message.getValue());
			System.out.println("Send message " + message.getValue());
			Div newLabel = new Div(new Span(message.getValue()));
			mainContent.add(newLabel);
			message.clear();
		});
		Div newMessageForm = new Div(message, addButton);

		mainContent.addClassName("main-layout__header");
		add(title);
		add(newMessageForm);
		add(mainContent);

		addClassName("main-layout");
	}
}
