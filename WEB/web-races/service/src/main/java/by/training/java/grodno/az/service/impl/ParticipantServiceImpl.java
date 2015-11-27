package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.HourseDao;
import by.training.java.grodno.az.data.dao.JockeyDao;
import by.training.java.grodno.az.data.dao.ParticipantDao;
import by.training.java.grodno.az.data.model.Hourse;
import by.training.java.grodno.az.data.model.Jockey;
import by.training.java.grodno.az.data.model.Participant;
import by.training.java.grodno.az.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantDao participantDao;

	@Autowired
	private HourseDao hourseDao;

	@Autowired
	private JockeyDao jockeyDao;

	@Override
	public Participant getById(int id) {
		return participantDao.get(id);
	}

	@Override
	public int insert(Participant entity) {
		return participantDao.insert(entity);
	}

	@Override
	public void update(Participant entity) {
		participantDao.update(entity);
	}

	@Override
	public void saveOrupdate(Participant entity) {
		if (participantDao.get(entity.getId()) != null) {
			participantDao.update(entity);
		} else {
			participantDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		participantDao.delete(id);
	}

	@Override
	public void delete(Participant entity) {
		participantDao.delete(entity);
	}

	@Override
	public Hourse getHourse(int hourse_id) {
		return hourseDao.get(hourse_id);
	}

	@Override
	public Jockey getJockey(int jockey_id) {
		return jockeyDao.get(jockey_id);
	}

	@Override
	public List<Participant> getAll() {
		return participantDao.getAll();
	}

	@Override
	public List<Participant> find(Map<String, Object> atributesFinding) {
		return participantDao.find(atributesFinding);
	}

}
