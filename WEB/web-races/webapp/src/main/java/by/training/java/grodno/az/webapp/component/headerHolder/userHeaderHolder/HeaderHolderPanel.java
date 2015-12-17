package by.training.java.grodno.az.webapp.component.headerHolder.userHeaderHolder;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.JavaEEComponent.Singleton;
import by.training.java.grodno.az.webapp.component.logoutInputPanel.InputPanel;
import by.training.java.grodno.az.webapp.component.logoutInputPanel.LogoutPanel;
import by.training.java.grodno.az.webapp.component.menuPanel.adminMenuPanel.AdminMainMenuPanel;
import by.training.java.grodno.az.webapp.component.menuPanel.playerMenuPanel.PlayerMainMenuPanel;

public class HeaderHolderPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public enum Menu {
		PLAYER, ADMIN
	}

	private String titleForPlayer = "Онлайн ставки на скачки";
	private String titleForAdmin = "Администрирование";

	public HeaderHolderPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		String role = Singleton.getInstance().getRole();
		
		if (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("player")) {
			add(new LogoutPanel("logout-input-panel"));
		} else {
			add(new InputPanel("logout-input-panel"));
		}

		switch (role) {
		case "player":
			add(new PlayerMainMenuPanel("main-menu-panel"));
			add(new Label("title", titleForPlayer));
			
			break;
		case "admin":
			add(new AdminMainMenuPanel("main-menu-panel"));
			add(new Label("title", titleForAdmin));
			break;
		default:
			add(new PlayerMainMenuPanel("main-menu-panel"));
			add(new Label("title", titleForPlayer));
			break;
		}

		
	}
}
