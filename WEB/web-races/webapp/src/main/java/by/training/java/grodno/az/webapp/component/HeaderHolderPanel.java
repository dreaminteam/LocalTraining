package by.training.java.grodno.az.webapp.component;

import org.apache.wicket.markup.html.panel.Panel;

public class HeaderHolderPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private String main_menu_panel = "main-menu-panel";
	private String input_panel = "input-panel";

	public HeaderHolderPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new InputPanel(input_panel));
		add(new MainMenuPanel(main_menu_panel));

	}

}
