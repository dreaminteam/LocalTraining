package by.training.java.grodno.az.webapp.page.registrationpage;

import javax.inject.Inject;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.component.registrationform.RegistrationUserForm;
import by.training.java.grodno.az.webapp.page.abstractpage.AbstractPage;

public class RegistrationPage extends AbstractPage {

	@Inject
	private UserService service;

	private User user;

	public RegistrationPage() {

	}

	public RegistrationPage(User user) {
		this.user = user;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new RegistrationUserForm("registration-user-form",user));
	}
}
