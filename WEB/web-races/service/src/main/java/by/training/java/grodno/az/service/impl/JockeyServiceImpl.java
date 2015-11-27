package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.JockeyDao;
import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.service.JockeyService;

@Service
public class JockeyServiceImpl implements JockeyService {

	@Autowired
	private JockeyDao jockeyDao;

	@Override
	public Jockey getById(int id) {
		return jockeyDao.get(id);
	}

	@Override
	public int insert(Jockey entity) {
		return jockeyDao.insert(entity);
	}

	@Override
	public void update(Jockey entity) {
		jockeyDao.update(entity);
	}

	@Override
	public void saveOrupdate(Jockey entity) {
		if (jockeyDao.get(entity.getId()) != null) {
			jockeyDao.update(entity);
		} else {
			jockeyDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		jockeyDao.delete(id);
	}

	@Override
	public void delete(Jockey entity) {
		jockeyDao.delete(entity);
	}

	@Override
	public List<Jockey> getAll() {
		return jockeyDao.getAll();
	}

	@Override
	public List<Jockey> find(Map<String, Object> atributesFinding) {
		return jockeyDao.find(atributesFinding);
	}

}
