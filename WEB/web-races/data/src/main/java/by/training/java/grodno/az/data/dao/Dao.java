package by.training.java.grodno.az.data.dao;

public interface Dao<T> {

	T get(int id);
	
	void insert(T persistent);
	
	void update(T persistent);
	
	void delete(int id);
	
	void delete(T persistent);
	
}
