package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.RateTypeDao;
import by.training.java.grodno.az.data.model.RateType;
import by.training.java.grodno.az.service.RateTypeService;

@Service
public class RateTypeServiceImpl implements RateTypeService {

	@Autowired
	private RateTypeDao rateTypeDao;

	@Override
	public RateType getById(int id) {
		return rateTypeDao.get(id);
	}

	@Override
	public int insert(RateType entity) {
		return rateTypeDao.insert(entity);
	}

	@Override
	public void update(RateType entity) {
		rateTypeDao.update(entity);
	}

	@Override
	public void saveOrUpdate(RateType entity) {
		if (rateTypeDao.get(entity.getId()) != null) {
			rateTypeDao.update(entity);
		} else {
			rateTypeDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		rateTypeDao.delete(id);
	}

	@Override
	public void delete(RateType entity) {
		rateTypeDao.delete(entity);
	}

	@Override
	public List<RateType> getAll() {
		return rateTypeDao.getAll();
	}

	@Override
	public List<RateType> find(Map<String, Object> atributesFinding) {
		return rateTypeDao.find(atributesFinding);
	}
}
