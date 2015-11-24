package by.training.java.grodno.az.data.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.dao.mapper.UserMapper;
import by.training.java.grodno.az.data.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User get(int id) {
		String sql = "select * from user where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserMapper());
	}

	@Override
	public void insert(User user) {
		String sql = "Insert INTO user(login,password,first_name,last_name,create_date) VALUE(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(),
				new Date());

	}

	@Override
	public void update(User persistent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User persistent) {
		// TODO Auto-generated method stub

	}

}
