package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.PlayerDao;
import by.training.java.grodno.az.data.dao.impl.PlayerDaoImpl;
import by.training.java.grodno.az.data.model.Player;
import by.training.java.grodno.az.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private PlayerDao playerDao;
	
	@Override
	public Player getById(int id) {

		return playerDao.get(id);
	}

}
