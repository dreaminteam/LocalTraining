package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.HourseRacingDao;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.service.HourseRacingService;

@Service
public class HourseRacingServiceImpl implements HourseRacingService {

	@Autowired
	private HourseRacingDao hourseRacingDao;

	@Override
	public HourseRacing getById(int id) {
		return hourseRacingDao.get(id);
	}

	@Override
	public int insert(HourseRacing entity) {
		return hourseRacingDao.insert(entity);
	}

	@Override
	public void update(HourseRacing entity) {
		hourseRacingDao.update(entity);
	}

	@Override
	public void saveOrupdate(HourseRacing entity) {
		if (hourseRacingDao.get(entity.getId()) != null) {
			hourseRacingDao.update(entity);
		} else {
			hourseRacingDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		hourseRacingDao.delete(id);
	}

	@Override
	public void delete(HourseRacing entity) {
		hourseRacingDao.delete(entity);
	}

}
