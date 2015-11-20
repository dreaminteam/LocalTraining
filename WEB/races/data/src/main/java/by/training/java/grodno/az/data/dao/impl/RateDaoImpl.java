package by.training.java.grodno.az.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.dao.RateDao;
import by.training.java.grodno.az.data.model.Rate;

@Repository
public class RateDaoImpl implements Dao<Rate>, RateDao {

	@Override
	public Rate get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Rate persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrupdate(Rate persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Rate persistent) {
		// TODO Auto-generated method stub

	}

}
