package by.training.java.grodno.az.webapp.page.loginPage;

import javax.inject.Inject;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.StringValidator;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.app.CustomSession;
import by.training.java.grodno.az.webapp.javaEEComponent.Singleton;
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
				getLogger().info(String.format("%s %s",loginModel.getObject(), passwordModel.getObject()));
				CustomSession.get().signIn(loginModel.getObject(), passwordModel.getObject());
				getLogger().info(String.format("%s", CustomSession.get().isSignedIn()));
				if (CustomSession.get().isSignedIn()) {
					Page homePage = new HomePage();
					homePage.info(String.format("%s, %s !", getString("all.welcome"),Session.get().getMetaData(CustomSession.USER_METADATA_KEY).getFullName()));
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
