package by.training.java.grodno.az.webapp.component.headerHolder.adminHeaderHolder;

import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.component.inputPanel.InputPanel;
import by.training.java.grodno.az.webapp.component.menuPanel.adminMenuPanel.AdminMainMenuPanel;
import by.training.java.grodno.az.webapp.component.menuPanel.userMenuPanel.UserMainMenuPanel;

public class AdminHeaderHolderPanel  extends Panel {

	private static final long serialVersionUID = 1L;

	private String admin_main_menu_panel = "admin-main-menu-panel";
	private String input_panel = "input-panel";

	public AdminHeaderHolderPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new InputPanel(input_panel));
		add(new AdminMainMenuPanel(admin_main_menu_panel));

	}

}
