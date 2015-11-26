package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.CoefficientDao;
import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.service.CoefficientService;

@Service
public class CoefficientServiceImpl implements CoefficientService {

	@Autowired
	private CoefficientDao coefficientDao;

	@Override
	public Coefficient getById(int id) {
		return coefficientDao.get(id);
	}

	@Override
	public int insert(Coefficient entity) {
		return coefficientDao.insert(entity);
	}

	@Override
	public void update(Coefficient entity) {
		coefficientDao.update(entity);
	}

	@Override
	public void saveOrupdate(Coefficient entity) {
		if (coefficientDao.get(entity.getId()) != null) {
			coefficientDao.update(entity);
		} else {
			coefficientDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		coefficientDao.delete(id);
	}

	@Override
	public void delete(Coefficient entity) {
		coefficientDao.delete(entity);
	}

}
