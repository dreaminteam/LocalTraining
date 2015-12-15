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

		if (role.equals("admin") || role.equals("player")) {
			System.out.println("adding logout botton");
			add(new LogoutPanel("logout-input-panel"));
			System.out.println("logout botton added");
		} else {
			add(new InputPanel("logout-input-panel"));
		}

		switch (role) {
		case "player":
			System.out.println("add(new PlayerMainMenuPanel(main-menu-panel))");
			add(new PlayerMainMenuPanel("main-menu-panel"));
			add(new Label("title", titleForPlayer));
			System.out.println("PlayerMainMenuPanel(main-menu-panel) added");
			
			break;
		case "admin":
			System.out.println("add new AdminMainMenuPanel");
			add(new AdminMainMenuPanel("main-menu-panel"));
			add(new Label("title", titleForAdmin));
			System.out.println("AdminMainMenuPanel added");
			break;
		default:
			System.out.println("case Default");
			break;
		}

		
	}
}
