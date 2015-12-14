package by.training.java.grodno.az.webapp.page.registrationPage;

import javax.inject.Inject;

import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.component.registrationForm.RegistrationUserForm;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;

public class RegistrationPage extends AbstractPage {

	@Inject
	private UserService service;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new RegistrationUserForm("registration-user-form"));
	}
}
