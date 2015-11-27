package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getById(int id) {
		return userDao.get(id);
	}

	@Override
	public User getByLogPas(String login, String password) {
		String pas = encryption(password);
		return userDao.getByLogPas(login, pas);
	}

	@Override
	public int insert(User entity) {
		return userDao.insert(entity);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void saveOrupdate(User entity) {
		if (userDao.get(entity.getId()) != null) {
			userDao.update(entity);
		} else {
			userDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public List<User> find(Map<String, Object> atributesFinding) {
		return userDao.find(atributesFinding);
	}

	@Override
	public String encryption(String source) {
		return DigestUtils.md5Hex(source);
	}

}
