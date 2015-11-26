package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.RateDao;
import by.training.java.grodno.az.data.model.Rate;
import by.training.java.grodno.az.service.RateService;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private RateDao rateDao;

	@Override
	public Rate getById(int id) {
		return rateDao.get(id);
	}

	@Override
	public int insert(Rate entity) {
		return rateDao.insert(entity);
	}

	@Override
	public void update(Rate entity) {
		rateDao.update(entity);
	}

	@Override
	public void saveOrupdate(Rate entity) {
		if (rateDao.get(entity.getId()) != null) {
			rateDao.update(entity);
		} else {
			rateDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		rateDao.delete(id);
	}

	@Override
	public void delete(Rate entity) {
		rateDao.delete(entity);
	}

}
