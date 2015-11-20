package by.training.java.grodno.az.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.dao.PlayerDao;
import by.training.java.grodno.az.data.model.Player;

@Repository
public class PlayerDaoImpl implements Dao<Player>, PlayerDao {

	@Override
	public Player get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Player persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrupdate(Player persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Player persistent) {
		// TODO Auto-generated method stub

	}

}
