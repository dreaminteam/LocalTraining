package by.training.java.grodno.az.data.dao;

import java.util.List;
import java.util.Map;

import by.training.java.grodno.az.data.model.AbstractEntity;

public interface Dao<T extends AbstractEntity> {

	T get(int id);

	int insert(T entity);

	void update(T entity);

	void delete(int id);

	void delete(T entity);

	List<T> getAll();
	
	List<T> getAll(String orderBy, boolean orderType);

	List<T> find(Map<String, Object> atributesFinding, String orderBy,boolean type);
	
	int getCount();

	


}
