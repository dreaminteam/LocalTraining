package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.ParticipantDao;
import by.training.java.grodno.az.data.model.Participant;
import by.training.java.grodno.az.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantDao participantDao;

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

}
