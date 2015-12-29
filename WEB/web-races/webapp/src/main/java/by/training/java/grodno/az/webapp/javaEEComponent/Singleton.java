package by.training.java.grodno.az.webapp.javaEEComponent;

import java.util.Date;

import by.training.java.grodno.az.data.model.User;

public class Singleton {

	private static User instance;

	private static String firstName = "admin";
	private static String lastName = "admin";
	private static String login = "admin";
	private static String password = "admin";
	private static String role="anaficus";

	private Singleton() {

	}

	public static User getInstance() {
		if (instance == null) {
			instance = createUser();
		}
		return instance;
	}

	private static User createUser() {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setBalance(0.0);
		user.setEmail("admin@mail.com");
		user.setLogin(login);
		user.setPassword(password);
		user.setCreateDate(new Date());
		user.setRole(role);
		return user;
	}

}
