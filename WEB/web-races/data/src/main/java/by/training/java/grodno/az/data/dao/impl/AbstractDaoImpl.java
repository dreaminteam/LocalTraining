package by.training.java.grodno.az.data.dao.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.AbstractDao;
import by.training.java.grodno.az.data.dao.EmployeeDao;
import by.training.java.grodno.az.data.dao.mapper.EmployeeMapper;
import by.training.java.grodno.az.data.dao.mapper.UserMapper;
import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.data.model.IPersistent;
import by.training.java.grodno.az.data.model.Player;

@Repository
public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Class clazz = this.getClass();
	private String tableName;
	private Class cl;

	{
		String simpleName = clazz.getSimpleName();
		int indOf = simpleName.indexOf("Dao");
		tableName = simpleName.substring(0, indOf);
		try {
			cl = Class.forName(tableName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T get(int id) {
		String sql = "select * from " + this.tableName + " where id=?";
		T result = null;

		result = (T) jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<T>());

		return result;
	}

	@Override
	public void insert(T entity) {
		String sql="insert into "+tableName+" values()";
	}

//	public int create(T entity) {
//
//        SimpleJdbcInsert jdbcInsert = new
//SimpleJdbcInsert(jdbcTemplate);
//
//
//jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns("id");
//
//
//
//        Map<String, Object> parameters = new HashMap<String,
//Object>();
//
//        parameters.put("name", entity.);
//
//        parameters.put("vipPlaceNumber", entity.getVipPlaceNumber());
//
//        parameters.put("simplePlaceNumber",
//entity.getSimplePlaceNumber());
//
//
//
//        Number key = jdbcInsert.executeAndReturnKey(new
//MapSqlParameterSource(parameters));
//
//        return ((Number) key).longValue();
//
// }
	
	private Map<String,Object> getMapAtributes(T entity){
		Map<String,Object> result=new HashMap<>();
		Field[] filds=entity.getClass().getDeclaredFields();
		return result;
	}
	
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}

}
