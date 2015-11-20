package by.training.java.grodno.az.data.dao;

import by.training.java.grodno.az.data.model.IPersistent;

public interface Dao<T extends IPersistent> {

	T get(int id);
	
	void insert(T persistent);

	void saveOrupdate(T persistent);
	
	void delete(int id);
	
	void delete(T persistent);
	
}
