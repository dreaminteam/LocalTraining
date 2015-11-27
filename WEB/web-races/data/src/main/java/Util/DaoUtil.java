package Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DaoUtil {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public <T> T getEntity(String sql, Class<T> entityClass, Object[] parameters) {
		T result = null;
		result = (T) jdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper<T>(entityClass));
		return result;
	}

}
