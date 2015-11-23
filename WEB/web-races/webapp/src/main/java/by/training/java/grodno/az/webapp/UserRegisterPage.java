package by.training.java.grodno.az.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		UserService bean = aContext.getBean(UserService.class);
		// bean.insert("log2", "pas1", "fName", "lName");
		User user = bean.get(2);
		System.out.print(user);

	}
}