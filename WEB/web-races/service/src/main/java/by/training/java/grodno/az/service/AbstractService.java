package by.training.java.grodno.az.service;

public interface AbstractService<T> {

	T getById(int id);
	
	void insert(T persistent);
	
	void update(T persistent);
	
	void delete(int id);
	
	void delete(T persistent);
	
}
