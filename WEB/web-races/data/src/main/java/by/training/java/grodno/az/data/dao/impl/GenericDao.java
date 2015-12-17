package by.training.java.grodno.az.data.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.model.AbstractEntity;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.data.util.DaoUtil;

@Repository
public abstract class GenericDao<T extends AbstractEntity> implements Dao<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DaoUtil daoUtil;

	private String tableName = getNameDBField(getGenericType().getSimpleName());

	@Override
	public T get(int id) {
		String sql = "select * from " + tableName + " where id=?";
		Object[] parameters = new Object[] { id };
		return daoUtil.getEntity(sql, getGenericType(), parameters);
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getCount() {

		String sql = String.format("SELECT COUNT(*) FROM %s", tableName);
		int coutn = jdbcTemplate.queryForInt(sql);
		return coutn;
	}

	@Override
	public List<T> getAll() {
		String sql = "select * from " + tableName;

		List<T> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(getGenericType()));

		return result;
	}

	@Override
	public List<T> getAll(String orderBy, boolean orderType) {
		if (orderBy == null) {
			return getAll();
		}
		String ordering = (orderType == true ? "asc" : "desc");
		String sql = String.format("select * from %s ORDER BY %s %s", tableName, orderBy, ordering);
		List<T> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(getGenericType()));
		return result;
	}

	@Override
	public List<T> find(Map<String, Object> atributesFinding, String orderBy, boolean orderType) {
		String atributes = getParametersStringForUpdate(atributesFinding);
		String sql = String.format("select * from %s", tableName);
		if (!atributes.equals("")) {
			sql = String.format("%s where %s", sql, atributes);
		}
		String ordering = (orderType == true ? "asc" : "desc");
		if (orderBy != null) {
			sql = String.format("%s ORDER BY %s %s", sql, orderBy, ordering);
		}
		List<T> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(getGenericType()));
		return result;
	}

	@Override
	public int insert(T entity) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName(tableName).usingGeneratedKeyColumns("id");
		Number key = -1;
		try {
			key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(getMapAtributes(entity)));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return key.intValue();
	}

	@Override
	public void update(T entity) {

		String sql = "update " + tableName + " set " + getParametersStringForUpdate(getMapAtributes(entity))
				+ " where id=?";
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
		LOGGER.info("Run method getGenericType(). Return {}", classOfObjectClass);
		;
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

	private String getNameDBField(String source) {
		StringBuilder sb = new StringBuilder();
		sb.append(source.charAt(0));
		for (int index = 1; index < source.length(); index++) {
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

	private String getParametersStringForUpdate(Map<String, Object> mapSource) {
		Map<String, Object> map = new HashMap<>();
		if (mapSource == null) {
			return "";
		}
		for (Map.Entry<String, Object> entry : mapSource.entrySet()) {
			String key = getNameDBField(entry.getKey());
			// if (!key.contains("Date")) {
			map.put(key, String.format("'%s'", entry.getValue()));
			// }
		}
		String source = map.toString();
		return String.format("%s", source.substring(1, source.length() - 1));
	}

}
