package by.training.java.grodno.az.data.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.model.AbstractEntity;

@Repository
public abstract class GenericDao<T extends AbstractEntity> implements Dao<T> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String tableName = getGenericType().getSimpleName();

	@Override
	public T get(int id) {
		String sql = "select * from " + tableName + " where id=?";
		T result = null;

		result = (T) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<T>(getGenericType()));

		return result;
	}

	@Override
	public int insert(T entity) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

		jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns("id");

		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(getMapAtributes(entity)));

		return key.intValue();
	}

	@Override
	public void update(T entity) {

		String sql = "update " + tableName + " set " + mapToUpdate(getMapAtributes(entity)) + " where id=?";
		jdbcTemplate.update(sql, new Object[] { entity.getId() });
	}

	@Override
	public void delete(int id) {
		String sql = "delete from " + tableName + " where id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	@Override
	public void delete(T entity) {
		String sql = "delete from " + tableName + " where id=?";
		jdbcTemplate.update(sql, new Object[] { entity.getId() });
	}

	private Class<T> getGenericType() {
		@SuppressWarnings("unchecked")
		Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return classOfObjectClass;
	}

	private Map<String, Object> getMapAtributes(T entity) {
		Map<String, Object> result = new HashMap<>();
		Method[] methods = entity.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().indexOf("get") == 0 && m.getName() != "getClass" && m.getName() != "getId") {
				String str = m.getName();
				try {
					result.put(getFieldNameByGetter(str), entity.getClass().getMethod(str, null).invoke(entity, null));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	private String nameDBField(String source) {
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < source.length(); index++) {
			char c = source.charAt(index);
			if (Character.isUpperCase(c)) {
				sb.append("_");
			}
			sb.append(c);
		}
		return sb.toString();
	}

	private String getFieldNameByGetter(String str) {
		StringBuilder sb = new StringBuilder(str.substring(3));
		char c = sb.charAt(0);
		sb.setCharAt(0, Character.toLowerCase(c));
		return sb.toString();
	}

	private String mapToUpdate(Map<String, Object> mapSource) {
		Map<String, Object> map = new HashMap<>();
		for (Map.Entry<String, Object> entry : mapSource.entrySet()) {
			String key = nameDBField(entry.getKey());
			if (!key.contains("Date")) {
				map.put(key, String.format("'%s'", entry.getValue()));
			}
		}
		String source = map.toString();
		return String.format("%s", source.substring(1, source.length() - 1));
	}
}
