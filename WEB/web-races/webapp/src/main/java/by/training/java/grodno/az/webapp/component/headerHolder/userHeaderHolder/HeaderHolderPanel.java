package by.training.java.grodno.az.webapp.component.headerHolder.userHeaderHolder;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.component.inputPanel.InputPanel;
import by.training.java.grodno.az.webapp.component.menuPanel.adminMenuPanel.AdminMainMenuPanel;
import by.training.java.grodno.az.webapp.component.menuPanel.userMenuPanel.UserMainMenuPanel;

public class HeaderHolderPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public enum Menu {
		PLAYER, ADMIN
	}

	private String main_menu_panel = "main-menu-panel";
	private String input_panel = "input-panel";
	private String menuName;
	private String titleForPlayer = "Онлайн ставки на скачки";
	private String titleForAdmin = "Администрирование";
	private String title=titleForPlayer;
	// private String titleForPlayer="Онлайн ставки на скачки";

	public HeaderHolderPanel(String id) {
		super(id);
		add(new UserMainMenuPanel(main_menu_panel));
	}

	public HeaderHolderPanel(String id, String menuName) {
		super(id);
		this.menuName = menuName;

	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new InputPanel(input_panel));
		System.out.println(menuName);

		if (menuName != null) {
			switch (Menu.valueOf(menuName)) {
			case PLAYER:
				System.out.println("add new UserMainMenuPanel");
				add(new UserMainMenuPanel(main_menu_panel));
				title = titleForPlayer;
				break;
			case ADMIN:
				System.out.println("add new AdminMainMenuPanel");
				add(new AdminMainMenuPanel(main_menu_panel));
				title = titleForAdmin;
				break;
			default:
				break;
			}
		}
		add(new Label("title", title));
	}

}
