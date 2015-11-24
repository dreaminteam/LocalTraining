package by.training.java.grodno.az.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.dao.impl.GenericDao;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;

@Service
public class UserServiceImpl extends GenericDao<User> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void insert(String login, String password, String firstName, String lastName) {
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setCreateDate(new Date());

		userDao.insert(user);

	}



}
