package by.training.java.grodno.az.service;

import java.util.List;
import java.util.Map;

import by.training.java.grodno.az.data.model.AbstractEntity;

public interface IService<T extends AbstractEntity> {

	T getById(int id);

	int insert(T entity);
	
	void update(T entity);

	void saveOrUpdate(T entity);

	void delete(int id);

	void delete(T entity);
	
	List<T> getAll();
	
	List<T> getAll(String orderBy, boolean orderType);
	
	List<T> find(Map<String, Object> atributesFinding, String orderBy,boolean type);

}
