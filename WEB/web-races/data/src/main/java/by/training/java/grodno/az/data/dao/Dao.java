package by.training.java.grodno.az.data.dao;

import by.training.java.grodno.az.data.model.AbstractEntity;

public interface Dao<T extends AbstractEntity> {

	T get(int id);

	int insert(T entity);

	void update(T entity);

	void delete(int id);

	void delete(T entity);

}
