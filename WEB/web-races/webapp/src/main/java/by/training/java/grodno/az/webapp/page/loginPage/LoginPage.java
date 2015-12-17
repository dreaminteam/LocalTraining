package by.training.java.grodno.az.webapp.page.loginPage;

import javax.inject.Inject;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.JavaEEComponent.Singleton;
import by.training.java.grodno.az.webapp.page.abstractPage.AbstractPage;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;

public class LoginPage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserService service;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Object> form = new Form<>("login-form");
		add(form);

		Model<String> loginModel = new Model<>();
		Model<String> passwordModel = new Model<>();

		TextField<String> loginTextField = new TextField<String>("login", loginModel);
		loginTextField.setRequired(true);
		loginTextField.add(StringValidator.maximumLength(20));
		form.add(loginTextField);

		PasswordTextField passwordTextField = new PasswordTextField("password", passwordModel);
		passwordTextField.setRequired(true);
		passwordTextField.add(StringValidator.maximumLength(40));
		form.add(passwordTextField);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				User user = service.getByLogPas(loginModel.getObject(), passwordModel.getObject());
				if (user != null) {
					Singleton.getInstance().setRole(user.getRole());
					Page homePage = new HomePage();
					homePage.info(String.format("Welcome, %s %s !", user.getFirstName(), user.getLastName()));
					;
					setResponsePage(homePage);
				} else {
					Page loginPage = new LoginPage();
					loginPage.warn("Login or password incorrect.");
					setResponsePage(loginPage);
				}

			}
		});

	}
}
