package by.training.java.grodno.az.webapp.component.registrationForm;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.include.Include;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.StringValidator;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.data.util.UserRole;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.JavaEEComponent.Role;
import by.training.java.grodno.az.webapp.JavaEEComponent.Singleton;
import by.training.java.grodno.az.webapp.page.admin.adminPage.AdminPage;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;
import by.training.java.grodno.az.webapp.page.registrationPage.RegistrationPage;

public class RegistrationUserForm extends Panel {

	private double startBalance = 1000.0;

	public RegistrationUserForm(String id) {
		super(id);
	}

	@Inject
	private UserService service;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		String role = Singleton.getInstance().getRole();
		
		final User newUser = new User();
		newUser.setRole(UserRole.Player.name());
		Form<User> form = new Form<>("form", new CompoundPropertyModel<>(newUser));
		add(form);

		TextField<String> fNameTextField = new TextField<String>("firstName");
		fNameTextField.setRequired(true);
		fNameTextField.add(StringValidator.maximumLength(45));
		form.add(fNameTextField);

		TextField<String> surnameTextField = new TextField<String>("surname");
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

		Model<String> model=new Model<>();
		List<String> choices = Arrays.asList(Role.admin.name(),Role.player.name());
		DropDownChoice<String> dropDownChoice = new DropDownChoice<>("drop-role", model, choices);
		dropDownChoice.setRequired(true);
		form.add(dropDownChoice);
		
//		Label label = new Label("this_component_will_determine_visibility");
//		form.add(label.setVisible(true));
		
		
//		if(role.equals("admin")){
//			label.setVisible(true);
//		}
		
		
		
		
		

		newUser.setBalance(startBalance);
		newUser.setCreateDate(new Date());

		// form.add(new CheckBox("active"));
		//
		// DateTextField dateTextField = new DateTextField("birthDate",
		// new StyleDateConverter("S-", true));
		// form.add(dateTextField);
		// DatePicker datePicker = new DatePicker() {
		// @Override
		// protected String getAdditionalJavaScript() {
		// return "${calendar}.cfg.setProperty(\"navigator\",true,false);
		// ${calendar}.render();";
		// }
		// };
		// datePicker.setShowOnFieldClick(true);
		// datePicker.setAutoHide(true);
		// dateTextField.add(datePicker);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				newUser.setPassword(service.encryption(newUser.getPassword()));
				service.insert(newUser);
				if (role.equals("admin")) {
					setResponsePage(new RegistrationPage());
				} else {
					setResponsePage(new HomePage());
				}

			}
		});
	}
}
