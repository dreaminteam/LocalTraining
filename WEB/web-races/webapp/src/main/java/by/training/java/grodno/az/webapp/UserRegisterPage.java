package by.training.java.grodno.az.webapp;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.data.model.Player;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.EmployeeService;
import by.training.java.grodno.az.service.PlayerService;
import by.training.java.grodno.az.service.UserService;

public class UserRegisterPage {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("spring-context.xml");

		User p = new User();
//	        p.setLogin("login4");
//	        p.setPassword("password");
//	        p.setFirstName("firstName");
//	        p.setLastName("lastName");
//	        p.setCreateDate(new Date());
		
		UserService bean = aContext.getBean(UserService.class);
//		User user=bean.getById(1);
//		System.out.println(user);
		
		User user=new User();
		
		user.setLogin("eter");
		user.setPassword("ertert");
		user.setFirstName("erte");
		user.setLastName("erterte");
		
		bean.insert(user);
		System.out.println(bean.getById(1));
		
//		bean.insert(p);
//		// bean.insert("log2", "pas1", "fName", "lName");
//		User user = bean.get(1);
//		System.out.println(user);
		System.out.println(true);
		
		EmployeeService b2=aContext.getBean(EmployeeService.class);
		Employee e=b2.getById(1);
		System.out.println(e.toString());
		
		
		
		PlayerService playerBean=aContext.getBean(PlayerService.class);
		Player player=playerBean.getById(1);
		System.out.println(player.toString());

	}
}