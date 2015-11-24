package by.training.java.grodno.az.webapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.data.model.Player;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.CoefficientService;
import by.training.java.grodno.az.service.EmployeeService;
import by.training.java.grodno.az.service.PlayerService;
import by.training.java.grodno.az.service.UserService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		UserService bean = aContext.getBean(UserService.class);
		// bean.insert("log2", "pas1", "fName", "lName");
		User user = bean.get(2);
		System.out.println(user);
		
//		EmployeeService b2=aContext.getBean(EmployeeService.class);
//		Employee e=b2.getById(1);
//		System.out.println(e.toString());
		
		
		
		PlayerService playerBean=aContext.getBean(PlayerService.class);
		Player player=playerBean.getById(1);
		System.out.println(player.toString());

	}
}