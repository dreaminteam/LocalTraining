package ru.example.wicket;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construct.
	 * 
	 * @param componentName
	 *            name of the component
	 * @param exampleTitle
	 *            title of the example
	 */

	public HeaderPanel(String componentName, String exampleTitle) {
		super(componentName);
		add(new Label("exampleTitle", exampleTitle));
	}

}
