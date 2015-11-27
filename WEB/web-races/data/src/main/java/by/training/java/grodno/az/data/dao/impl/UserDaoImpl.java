package by.training.java.grodno.az.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.User;

@Repository
public class UserDaoImpl extends GenericDao<User>implements UserDao {

	@Override
	public User getByLogPas(String login, String password) {
//		String sql = String.format("select * from user where login=?);
		return null;
	}

	

}
