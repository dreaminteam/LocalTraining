package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.CoefficientDao;
import by.training.java.grodno.az.data.dao.RacingLineDao;
import by.training.java.grodno.az.data.dao.RateLineDao;
import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.data.model.RateLine;
import by.training.java.grodno.az.service.CoefficientService;

@Service
public class CoefficientServiceImpl implements CoefficientService {

	@Autowired
	private CoefficientDao coefficientDao;

	@Autowired
	private RateLineDao rateLineDao;

	@Autowired
	private RacingLineDao racingLineDao;

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
	public void saveOrUpdate(Coefficient entity) {
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

	@Override
	public RateLine getRateLine(int rateLine_id) {
		return rateLineDao.get(rateLine_id);
	}

	@Override
	public RacingLine getRacingLine(int racingLine_id) {
		return racingLineDao.get(racingLine_id);
	}

	@Override
	public List<Coefficient> getAll() {
		return coefficientDao.getAll();
	}

	@Override
	public List<Coefficient> find(Map<String, Object> atributesFinding) {
		return coefficientDao.find(atributesFinding);
	}

}
