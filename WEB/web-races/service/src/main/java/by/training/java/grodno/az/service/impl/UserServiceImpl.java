package by.training.java.grodno.az.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.dao.impl.GenericDao;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public int insert(User u) {
		return userDao.insert(u);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}


	



}
