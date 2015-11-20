package by.training.java.grodno.az.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.training.java.grodno.az.service.UserService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		UserService bean = aContext.getBean(UserService.class);
		System.out.print(true);
	}
}