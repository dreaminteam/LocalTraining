package by.training.java.grodno.az.webapp.page.admin.employeePage;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.registrationPage.RegistrationPage;

public class EmployeePage extends AbstractPage{

	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new BookmarkablePageLink<Void>("registration-page",RegistrationPage.class));
		
	}
}
