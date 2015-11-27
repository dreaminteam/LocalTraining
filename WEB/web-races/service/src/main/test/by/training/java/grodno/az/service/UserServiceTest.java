package by.training.java.grodno.az.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.training.java.grodno.az.data.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-spring-context.xml")
public class UserServiceTest {

	@Autowired
	private UserService service;
	
//	@Autowired
//	private TestUtil util;

	@Test
	public void insertTest() {

		User user = new User();
//		String login = util.getRandomString(20);
//		String password = service.encryption(util.getRandomString(20));
//		String firstName = util.getRandomString(20);
//		String lastName = util.getRandomString(20);
		
		String login = "qwertyuiop";
		String password = service.encryption("asdfghjkl");
		String firstName = "zxcvbnm";
		String lastName = "1234567890";
		
		Date createDate = new Date();
		Date endDate = new Date();

		user.setCreateDate(createDate);
		user.setEndDate(endDate);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setLogin(login);
		user.setPassword(password);
		
		service.insert(user);
		
		User checkUser=service.getById(1);
		String check_login = checkUser.getLogin();
		String check_password = checkUser.getPassword();
		String check_firstName = checkUser.getFirstName();
		String check_lastName = checkUser.getLastName();
		Date check_createDate = checkUser.getCreateDate();
		Date check_endDate = checkUser.getEndDate();
		
		Assert.assertEquals(login, check_login);
		Assert.assertEquals(password, check_password);
		Assert.assertEquals(firstName, check_firstName);
		Assert.assertEquals(lastName, check_lastName);
		Assert.assertEquals(createDate, check_createDate);
		Assert.assertEquals(endDate, check_endDate);
		

	}

}
