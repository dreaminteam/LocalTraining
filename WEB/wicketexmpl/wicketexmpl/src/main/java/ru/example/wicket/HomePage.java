package ru.example.wicket;

import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

		add(new Label("message", "Примеры wicket"));

	}
}
