package by.training.java.grodno.az.data.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.RacingLineDao;
import by.training.java.grodno.az.data.dao.mapper.ParticipantViewMapper;
import by.training.java.grodno.az.data.entities.ParticipantView;
import by.training.java.grodno.az.data.entities.RacingLineView;
import by.training.java.grodno.az.data.model.RacingLine;

@Repository
public class RacingLineDaoImpl extends GenericDao<RacingLine>implements RacingLineDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

}
