package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.PlayerDao;
import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.Player;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDao playerDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Player getById(int id) {
		return playerDao.get(id);
	}

	@Override
	public int insert(Player entity) {
		return playerDao.insert(entity);
	}

	@Override
	public void update(Player entity) {
		playerDao.update(entity);
	}

	@Override
	public void insertOrUpdate(Player entity) {
		if (playerDao.get(entity.getId()) != null) {
			playerDao.update(entity);
		} else {
			playerDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		playerDao.delete(id);
	}

	@Override
	public void delete(Player entity) {
		playerDao.delete(entity);
	}

	@Override
	public User getUser(int user_id) {
		return userDao.get(user_id);
	}

	@Override
	public List<Player> getAll() {
		return playerDao.getAll();
	}
	
	@Override
	public List<Player> getAll(String orderBy, boolean orderType) {
		List<Player> result = playerDao.getAll(orderBy, orderType);
		return result;
	}
	
	@Override
	public List<Player> getAll(Map<String, Object> atributesFinding, String orderBy,boolean type) {
		return playerDao.getAll(atributesFinding,orderBy,type);
	}
	
	@Override
	public List<Player> getAll(int first, int count) {
		List<Player> result= playerDao.getAll(first,count);
		return result;
	}

	@Override
	public List<Player> getAll(int first, int count, String orderBy, boolean orderType) {
		List<Player> result= playerDao.getAll(first,count,orderBy,orderType);
		return result;
	}

	@Override
	public List<Player> getAll(Map<String, Object> atributesFinding, int first, int count, String orderBy,
			boolean orderType) {
		List<Player> result= playerDao.getAll(atributesFinding,first,count,orderBy,orderType);
		return result;
	}

	@Override
	public int getCount() {
		return playerDao.getCount();
	}
	
}
