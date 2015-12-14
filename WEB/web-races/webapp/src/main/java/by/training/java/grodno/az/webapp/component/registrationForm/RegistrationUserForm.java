package by.training.java.grodno.az.webapp.component.registrationForm;

import java.util.Date;

import javax.inject.Inject;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.data.util.UserRole;
import by.training.java.grodno.az.service.UserService;
import by.training.java.grodno.az.webapp.page.homePage.HomePage;

public class RegistrationUserForm extends Panel{

	public RegistrationUserForm(String id) {
		super(id);
	}

	@Inject
	private UserService service;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		final User newUser = new User();
		newUser.setRole(UserRole.Player.name());
		Form<User> form = new Form<>("form", new CompoundPropertyModel<>(newUser));
		add(form);

		form.add(new TextField<String>("firstName"));
		form.add(new TextField<String>("surname"));
		form.add(new TextField<String>("email"));
		form.add(new TextField<String>("login"));
		form.add(new PasswordTextField("password"));
	
		newUser.setBalance(1000.0);
		newUser.setCreateDate(new Date());
		
		
//		form.add(new CheckBox("active"));
//
//		DateTextField dateTextField = new DateTextField("birthDate",
//				new StyleDateConverter("S-", true));
//		form.add(dateTextField);
//		DatePicker datePicker = new DatePicker() {
//			@Override
//			protected String getAdditionalJavaScript() {
//				return "${calendar}.cfg.setProperty(\"navigator\",true,false); ${calendar}.render();";
//			}
//		};
//		datePicker.setShowOnFieldClick(true);
//		datePicker.setAutoHide(true);
//		dateTextField.add(datePicker);

		form.add(new SubmitLink("submit-button") {
			@Override
			public void onSubmit() {
				newUser.setPassword(service.encryption(newUser.getPassword()));
				service.insert(newUser);
				setResponsePage(new HomePage());
			}
		});
	}
}
