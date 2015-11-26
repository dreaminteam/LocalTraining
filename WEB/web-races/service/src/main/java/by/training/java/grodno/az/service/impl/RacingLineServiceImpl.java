package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.RacingLineDao;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.service.RacingLineService;

@Service
public class RacingLineServiceImpl implements RacingLineService {

	@Autowired
	private RacingLineDao racingLineDao;

	@Override
	public RacingLine getById(int id) {
		return racingLineDao.get(id);
	}

	@Override
	public int insert(RacingLine entity) {
		return racingLineDao.insert(entity);
	}

	@Override
	public void update(RacingLine entity) {
		racingLineDao.update(entity);
	}

	@Override
	public void saveOrupdate(RacingLine entity) {
		if (racingLineDao.get(entity.getId()) != null) {
			racingLineDao.update(entity);
		} else {
			racingLineDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		racingLineDao.delete(id);
	}

	@Override
	public void delete(RacingLine entity) {
		racingLineDao.delete(entity);
	}

}
