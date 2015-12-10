package by.training.java.grodno.az.webapp.component;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import by.training.java.grodno.az.webapp.page.LoginPage;
import by.training.java.grodno.az.webapp.page.RegistrationPage;

public class InputPanel extends Panel{

	private static final long serialVersionUID = 1L;

	
	public InputPanel(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		

		add(new BookmarkablePageLink<Void>("login-page-link",LoginPage.class));
		add(new BookmarkablePageLink<Void>("registration-page-link",RegistrationPage.class));

	}

}
