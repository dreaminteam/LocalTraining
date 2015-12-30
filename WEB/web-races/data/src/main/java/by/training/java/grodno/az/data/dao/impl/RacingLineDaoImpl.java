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
	
	@Override
	public List<RacingLineView> getView() {
		String sql = "select p.id,j.first_name as jockey_firstname,j.last_name as jockey_lastname,h.name as hourse_name"
				+ " from participant as p join jockey as j on p.jockey_id=j.id"
				+ " join hourse as h on p.hourse_id=h.id order by p.id;";

		List<ParticipantView> result = jdbcTemplate.query(sql, new RacingLineViewMapper());
		return result;
	}

}
