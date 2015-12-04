package ru.example.wicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class FooterPanel extends Panel {

	public FooterPanel(String id, String text) {
		super(id);
		add(new Label("footerpanel_text", text));
	}

}
