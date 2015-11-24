package by.training.java.grodno.az.data.dao;

import by.training.java.grodno.az.data.model.IPersistent;

public interface AbstractDao<T> {

	T get(int id);
	
	void insert(T persistent);
	
	void update(T persistent);
	
	void delete(int id);
	
	void delete(T persistent);
	
}
