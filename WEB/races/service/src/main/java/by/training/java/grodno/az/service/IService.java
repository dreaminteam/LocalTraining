package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.IPersistent;

public interface IService<T extends IPersistent> {
	
	T get(int id);
	
	void insert(T persistent);

	void saveOrupdate(T persistent);
	
	void delete(int id);
	
	void delete(T persistent);

}
