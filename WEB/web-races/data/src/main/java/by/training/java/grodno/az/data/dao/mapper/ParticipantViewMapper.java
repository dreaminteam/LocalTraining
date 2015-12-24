package by.training.java.grodno.az.data.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import by.training.java.grodno.az.data.entities.ParticipantView;

public class ParticipantViewMapper implements RowMapper<ParticipantView> {

	@Override
	public ParticipantView mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id=rs.getInt("p.id");
		String jockeyFirstName=rs.getString("jockey_firstname");
		String jockeyLastName=rs.getString("jockey_lastname");
		String hourseName=rs.getString("hourse_name");
		ParticipantView pView=new ParticipantView();
		pView.setParticipantId(id);
		pView.setJockeyFullName(String.format("%s %s", jockeyFirstName,jockeyLastName));
		pView.setHourseName(hourseName);
		return pView;
	}

}
