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

	private Class<T> getGenericType() {
		@SuppressWarnings("unchecked")
		Class<T> classOfObjectClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return classOfObjectClass;
	}

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
		String table = String.format("%s(%s)", tableName, fieldValauToUpdate(entity).get(0));
		String values = String.format("%s(%s)", tableName, fieldValauToUpdate(entity).get(1));
		String sql = "insert into " + table + " " + values + " where id=?";
		System.out.println("******************");
		System.out.println(sql);
		System.out.println("******************");
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

	private Map<String, Object> getMapAtributes(T entity) {
		Map<String, Object> result = new HashMap<>();
		Method[] methods = entity.getClass().getMethods();
		for (Method m : methods) {
			if (m.getName().indexOf("get") == 0 && m.getName() != "getClass" && m.getName() != "getId") {
				String str = m.getName();
				try {
					result.put(getFieldName(str), entity.getClass().getMethod(str, null).invoke(entity, null));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return result;
	}

	private static String fieldToUpdate(String source) {
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < source.length(); index++) {
			char c = source.charAt(index);
			if (Character.isUpperCase(c)) {
				sb.append("_");
			}
			sb.append(c);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	// TEST
	public static void main(String[] args) {
		fieldToUpdate("getFirstNameOfMy");
	}

	private String getFieldName(String str) {
		StringBuilder sb = new StringBuilder(str.substring(3));
		char c = sb.charAt(0);
		sb.setCharAt(0, Character.toLowerCase(c));
		return sb.toString();
	}

	private List<String> fieldValauToUpdate(T entity) {
		List<String> result = new ArrayList<>(2);
		StringBuilder fields = new StringBuilder();
		StringBuilder values = new StringBuilder();
		HashMap<String, Object> map = (HashMap<String, Object>) getMapAtributes(entity);
		System.out.println(map);
		System.out.println("sixe="+map.size());
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			fields.append(String.format("%s", getFieldName((String) pair.getKey())));
			values.append(String.format("'%s'", pair.getValue()));
			System.out.println(fields+"-"+values);
			it.next();
		}

		result.add(fields.toString());
		result.add(values.toString());
		return result;
	}
}
