package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.HourseDao;
import by.training.java.grodno.az.data.model.Hourse;
import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.service.HourseService;

@Service
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
	public void saveOrUpdate(Hourse entity) {
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

	@Override
	public List<Hourse> getAll() {
		return hourseDao.getAll();
	}
	
	@Override
	public List<Hourse> getAll(String orderBy, boolean orderType) {
		List<Hourse> result = hourseDao.getAll(orderBy, orderType);
		return result;
	}

	@Override
	public List<Hourse> find(Map<String, Object> atributesFinding, String orderBy,boolean type) {
		return hourseDao.find(atributesFinding,orderBy,type);
	}

}
