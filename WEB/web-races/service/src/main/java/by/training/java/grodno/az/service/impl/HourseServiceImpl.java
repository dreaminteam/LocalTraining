package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import by.training.java.grodno.az.data.dao.HourseDao;
import by.training.java.grodno.az.data.model.Hourse;
import by.training.java.grodno.az.service.HourseService;

public class HourseServiceImpl implements HourseService {

	@Autowired
	private HourseDao hourseDao;

	@Override
	public Hourse getById(int id) {
		return hourseDao.get(id);
	}

	@Override
	public int insert(Hourse entity) {
		return hourseDao.insert(entity);
	}

	@Override
	public void update(Hourse entity) {
		hourseDao.update(entity);
	}

	@Override
	public void saveOrupdate(Hourse entity) {
		if (hourseDao.get(entity.getId()) != null) {
			hourseDao.update(entity);
		} else {
			hourseDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		hourseDao.delete(id);
	}

	@Override
	public void delete(Hourse entity) {
		hourseDao.delete(entity);
	}

}
