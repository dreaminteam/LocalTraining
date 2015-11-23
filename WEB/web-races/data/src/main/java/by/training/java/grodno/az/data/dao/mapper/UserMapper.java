package by.training.java.grodno.az.data.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import by.training.java.grodno.az.data.model.User;


public final class UserMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String login=rs.getString("login");
		String password=rs.getString("password");
		String firstName = rs.getString("first_name");
		String lastName = rs.getString("last_name");
		Date createDate=rs.getDate("create_date");
		Date endDate=rs.getDate("end_date");
		User user = new User();
		user.setId(id);
		user.setLogin(login);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setCreateDate(createDate);
		user.setEndDate(endDate);
		return user;
	}
}