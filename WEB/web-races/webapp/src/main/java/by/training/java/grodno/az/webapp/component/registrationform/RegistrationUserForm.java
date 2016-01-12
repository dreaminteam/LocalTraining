package by.training.java.grodno.az.webapp.component.registrationform;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.app.UserSession;
import by.training.java.grodno.az.webapp.enums.Role;
import by.training.java.grodno.az.webapp.page.admin.userspage.UsersPage;
import by.training.java.grodno.az.webapp.page.homepage.HomePage;
import by.training.java.grodno.az.webapp.page.registrationpage.RegistrationPage;

public class RegistrationUserForm extends Panel {
	private static final long serialVersionUID = 1L;

	private double startBalance = 1000.0;

	private User user;
	private boolean isNew;

	public RegistrationUserForm(String id) {
		super(id);
		this.user = new User();
		isNew = true;
		this.user.setCreateDate(new Date());
		this.user.setBalance(startBalance);
	}

	public RegistrationUserForm(String id, User user) {
		super(id);
		if (user == null) {
			this.user = new User();
			this.user.setCreateDate(new Date());
			this.user.setBalance(startBalance);
			isNew = true;
		} else {
			this.user = user;
			isNew = false;
		}
	}

	@Inject
	private UserService service;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<User> form = new Form<>("registration-form", new CompoundPropertyModel<>(user));
		add(form);

		TextField<String> fNameTextField = new TextField<String>("firstName");
		fNameTextField.setRequired(true);
		fNameTextField.add(StringValidator.maximumLength(45));
		form.add(fNameTextField);

		TextField<String> surnameTextField = new TextField<String>("lastName");
		surnameTextField.setRequired(true);
		surnameTextField.add(StringValidator.maximumLength(45));
		form.add(surnameTextField);

		EmailTextField emailTextField = new EmailTextField("email");
		emailTextField.setRequired(true);
		emailTextField.add(EmailAddressValidator.getInstance());
		form.add(emailTextField);

		TextField<String> loginTextField = new TextField<String>("login");
		loginTextField.setRequired(true);
		loginTextField.add(StringValidator.maximumLength(20));
		form.add(loginTextField);

		PasswordTextField passwordTextField = new PasswordTextField("password");

		passwordTextField.setRequired(true);
		passwordTextField.add(StringValidator.maximumLength(40));

		form.add(passwordTextField);
		if (!isNew && UserSession.get().getMetaData(UserSession.USER_METADATA_KEY).getUserId() != user.getId()) {
			passwordTextField.setVisible(false);
		}

		Model<String> roleModel = new Model<>();
		List<String> choices = Arrays.asList(Role.admin.name().toLowerCase(), Role.player.name().toLowerCase());
		DropDownChoice<String> dropDownChoice = new DropDownChoice<>("drop-role", roleModel, choices);
		dropDownChoice.setRequired(true);
		form.add(dropDownChoice);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				String pass = service.encryption(user.getPassword());
				user.setPassword(pass);
				user.setRole(roleModel.getObject());
				if (!UserSession.get().isSignedIn()) {

					if (service.insert(user) < 0) {
						RegistrationPage registrPage = new RegistrationPage(user);
						registrPage.error("login is already taken");
						user.setLogin("");
						setResponsePage(registrPage);
					} else {
						HomePage homePage = new HomePage();
						homePage.info("new user created !!!");
						setResponsePage(homePage);
					}
				} else {
					service.insertOrUpdate(user);

					RegistrationPage pageToResponse = new RegistrationPage(user);
					if (isNew) {
						pageToResponse.info("new user created !!!");
					} else {
						pageToResponse.info("user updated!!!");
					}
					setResponsePage(pageToResponse);
				}

			};
		});

		add(new UsersPageLink("users-page-link", UsersPage.class));

	}

	@AuthorizeAction(roles = { "admin" }, action = Action.RENDER)
	private class UsersPageLink extends BookmarkablePageLink {

		public UsersPageLink(String id, Class pageClass) {
			super(id, pageClass);
		}

	}
}
