package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public static void main(String[] args) {
		String password = "admin";
		System.out.println(new UserServiceImpl().encryption(password));
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public User getById(int id) {
		User user = userDao.get(id);
		LOGGER.info("Get by id {}", user);
		return user;
	}

	@Override
	public User getByLogPas(String login, String password) {
		String pas = encryption(password);
		User user = userDao.getByLogPas(login, pas);
		LOGGER.info("Get by login and password {}", user);
		return user;
	}

	@Override
	public int insert(User entity) {
		int index = userDao.insert(entity);
		LOGGER.info("Insert {} with id={}", entity, index);
		return index;
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
		LOGGER.info("Update user with id={} to {}", entity.getId(), entity);
	}

	@Override
	public void insertOrUpdate(User entity) {
		LOGGER.debug("Start SaveOrUpdate method", entity.getId(), entity);
		if (getById(entity.getId()) != null) {
			update(entity);
		} else {
			insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		LOGGER.info("Delete by user with id={}", id);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);
		LOGGER.info("Delete {}", entity);
	}

	@Override
	public List<User> getAll() {
		List<User> result = userDao.getAll();
		LOGGER.info("Return list of all users.");
		return result;
	}

	@Override
	public List<User> getAll(Map<String, Object> atributesFinding, String orderBy, boolean type) {
		return userDao.getAll(atributesFinding, orderBy, type);
	}

	@Override
	public String encryption(String source) {
		return DigestUtils.md5Hex(source);
	}

	@Override
	public List<User> getAll(String orderBy, boolean orderType) {
		List<User> result = userDao.getAll(orderBy, orderType);
		LOGGER.info("Return list of all users.");
		return result;
	}

	@Override
	public List<User> getAll(int first, int count) {
		List<User> result = userDao.getAll(first, count);
		LOGGER.info("Return list of all users.");
		return result;
	}

	@Override
	public List<User> getAll(int first, int count, String orderBy, boolean orderType) {
		List<User> result = userDao.getAll(first, count, orderBy, orderType);
		LOGGER.info("Return list of all users.");
		return result;
	}

	@Override
	public List<User> getAll(Map<String, Object> atributesFinding, int first, int count, String orderBy,
			boolean orderType) {
		List<User> result = userDao.getAll(atributesFinding, first, count, orderBy, orderType);
		LOGGER.info("Return list of all users.");
		return result;
	}

	@Override
	public int getCount() {
		return userDao.getCount();
	}

	@Override
	public int getCount(Map<String, Object> atributesFinding) {
		return userDao.getCount(atributesFinding);
	}

}
