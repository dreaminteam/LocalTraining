package by.training.java.grodno.az.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.User;

@Repository
public class UserDaoImpl implements Dao<User>, UserDao {

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrupdate(User persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User persistent) {
		// TODO Auto-generated method stub

	}

}
