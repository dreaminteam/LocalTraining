package by.training.java.grodno.az.data.dao.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.dao.EmployeeDao;
import by.training.java.grodno.az.data.dao.mapper.EmployeeMapper;
import by.training.java.grodno.az.data.dao.mapper.UserMapper;
import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.data.model.IPersistent;
import by.training.java.grodno.az.data.model.Player;
import java.lang.reflect.ParameterizedType;

@Repository
public abstract class GenericDao<T> implements Dao<T> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Class clazz = this.getClass();
	private String tableName;
	private Class cl;
	private Class classOfObjectClass;

	{
		System.out.println("0: " + Player.class.getName());

		String simpleClassName = clazz.getSimpleName();
		int indOf = simpleClassName.indexOf("Dao");
		if (indOf > 0) {
			tableName = simpleClassName.substring(0, indOf);
		}
		String className = clazz.getName();
		System.out.println("1: className=" + className);
		int indOfClass = className.indexOf("dao.impl");
		if (indOfClass > 0) {
			String pathT = className.substring(0, indOfClass) + "model." + tableName;
			try {
				System.out.println("2: pathT=" + pathT);
				classOfObjectClass = Class.forName(pathT);
				System.out.println("3: classOfObjectClass.getName()=" + classOfObjectClass.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public T get(int id) {
		String sql = "select * from " + this.tableName + " where id=?";
		T result = null;

		result = (T) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<T>(classOfObjectClass));

		return result;
	}

	@Override
	public void insert(T entity) {
		String sql = "insert into " + tableName + " values()";
	}

	// public int create(T entity) {
	//
	// SimpleJdbcInsert jdbcInsert = new
	// SimpleJdbcInsert(jdbcTemplate);
	//
	//
	// jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns("id");
	//
	//
	//
	// Map<String, Object> parameters = new HashMap<String,
	// Object>();
	//
	// parameters.put("name", entity.);
	//
	// parameters.put("vipPlaceNumber", entity.getVipPlaceNumber());
	//
	// parameters.put("simplePlaceNumber",
	// entity.getSimplePlaceNumber());
	//
	//
	//
	// Number key = jdbcInsert.executeAndReturnKey(new
	// MapSqlParameterSource(parameters));
	//
	// return ((Number) key).longValue();
	//
	// }

	private Map<String, Object> getMapAtributes(T entity) {
		Map<String, Object> result = new HashMap<>();
		Field[] filds = entity.getClass().getDeclaredFields();
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
