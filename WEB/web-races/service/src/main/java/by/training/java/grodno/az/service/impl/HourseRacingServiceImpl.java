package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.HourseRacingDao;
import by.training.java.grodno.az.data.model.Hourse;
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
	public void insertOrUpdate(HourseRacing entity) {
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

	@Override
	public List<HourseRacing> getAll() {
		return hourseRacingDao.getAll();
	}
	
	@Override
	public List<HourseRacing> getAll(String orderBy, boolean orderType) {
		List<HourseRacing> result = hourseRacingDao.getAll(orderBy, orderType);
		return result;
	}
	
	@Override
	public List<HourseRacing> getAll(Map<String, Object> atributesFinding, String orderBy,boolean type) {
		return hourseRacingDao.getAll(atributesFinding,orderBy,type);
	}

	@Override
	public List<HourseRacing> getAll(int first, int count) {
		List<HourseRacing> result= hourseRacingDao.getAll(first,count);
		return result;
	}

	@Override
	public List<HourseRacing> getAll(int first, int count, String orderBy, boolean orderType) {
		List<HourseRacing> result= hourseRacingDao.getAll(first,count,orderBy,orderType);
		return result;
	}

	@Override
	public List<HourseRacing> getAll(Map<String, Object> atributesFinding, int first, int count, String orderBy,
			boolean orderType) {
		List<HourseRacing> result= hourseRacingDao.getAll(atributesFinding,first,count,orderBy,orderType);
		return result;
	}
	
	@Override
	public int getCount() {
		return hourseRacingDao.getCount();
	}
}
