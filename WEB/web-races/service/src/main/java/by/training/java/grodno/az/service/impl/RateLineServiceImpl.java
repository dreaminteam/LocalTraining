package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.RateLineDao;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.service.RateLineService;

@Service
public class RateLineServiceImpl implements RateLineService {

	@Autowired
	private RateLineDao rateLineDao;

	@Override
	public RateLine getById(int id) {
		return rateLineDao.get(id);
	}

	@Override
	public int insert(RateLine entity) {
		return rateLineDao.insert(entity);
	}

	@Override
	public void update(RateLine entity) {
		rateLineDao.update(entity);
	}

	@Override
	public void saveOrupdate(RateLine entity) {
		if (rateLineDao.get(entity.getId()) != null) {
			rateLineDao.update(entity);
		} else {
			rateLineDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		rateLineDao.delete(id);
	}

	@Override
	public void delete(RateLine entity) {
		rateLineDao.delete(entity);
	}

	@Override
	public List<RateLine> getAll() {
		return rateLineDao.getAll();
	}

	@Override
	public List<RateLine> find(Map<String, Object> atributesFinding) {
		return rateLineDao.find(atributesFinding);
	}

}
