package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.HourseRacingDao;
import by.training.java.grodno.az.data.dao.ParticipantDao;
import by.training.java.grodno.az.data.dao.RacingLineDao;
import by.training.java.grodno.az.data.model.HourseRacing;
import by.training.java.grodno.az.data.model.Participant;
import by.training.java.grodno.az.data.model.RacingLine;
import by.training.java.grodno.az.service.RacingLineService;

@Service
public class RacingLineServiceImpl implements RacingLineService {

	@Autowired
	private RacingLineDao racingLineDao;

	@Autowired
	private HourseRacingDao hourseRacingDao;

	@Autowired
	private ParticipantDao participantDao;

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

	@Override
	public HourseRacing getHourseRacing(int hourseRacing_id) {
		return hourseRacingDao.get(hourseRacing_id);
	}

	@Override
	public Participant getParticipant(int participant_id) {
		return participantDao.get(participant_id);
	}

	@Override
	public List<RacingLine> getAll() {
		return racingLineDao.getAll();
	}

	@Override
	public List<RacingLine> find(Map<String, Object> atributesFinding) {
		return racingLineDao.find(atributesFinding);
	}

}
