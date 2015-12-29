package by.training.java.grodno.az.webapp.component.logoutInputPanel;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.app.CustomSession;
import by.training.java.grodno.az.webapp.javaEEComponent.Singleton;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;

public class LogoutPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LogoutPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new Link<Void>("logout") {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				CustomSession.get().signOut();
				setResponsePage(new HomePage());
			}
		});

	}

}
