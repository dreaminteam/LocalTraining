package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.PlayerDao;
import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.Player;
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
	public void saveOrupdate(Player entity) {
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
	public List<Player> find(Map<String, Object> atributesFinding) {
		return playerDao.find(atributesFinding);
	}

}
