package by.training.java.grodno.az.webapp.component.headerHolder.userHeaderHolder;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import by.training.java.grodno.az.webapp.JavaEEComponent.Singleton;
import by.training.java.grodno.az.webapp.app.CustomSession;
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
		
		String userName="Not authorizetion user";
		if(CustomSession.get().isSignedIn()){
			userName=CustomSession.get().getFullName();
		}
		
		Label label = new Label("user-name-label", userName);
		label.add(AttributeModifier.append("color", new Model<String>("white")));
		add(label);
		
		Set<String> role = CustomSession.get().getRoles();

		if (role == null) {
			add(new InputPanel("logout-input-panel"));
			add(new PlayerMainMenuPanel("main-menu-panel"));
			add(new Label("title", titleForPlayer));
		} else {
			add(new LogoutPanel("logout-input-panel"));

			switch (role.toString()) {
			case "player":
				add(new PlayerMainMenuPanel("main-menu-panel"));
				add(new Label("title", titleForPlayer));

				break;
			case "admin":
				add(new AdminMainMenuPanel("main-menu-panel"));
				add(new Label("title", titleForAdmin));
				break;

			}
		}
	}
}
