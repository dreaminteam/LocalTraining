package by.training.java.grodno.az.webapp.component.logoutInputPanel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.JavaEEComponent.Singleton;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;

public class LogoutPanel extends Panel {

	public LogoutPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("logout") {

			@Override
			public void onClick() {
				if (Singleton.getInstance().getRole().equals("admin")) {
					Singleton.getInstance().setRole("player");
				}else{
					Singleton.getInstance().setRole("admin");
				}
				setResponsePage(new HomePage());
			}
		});

	}

}
