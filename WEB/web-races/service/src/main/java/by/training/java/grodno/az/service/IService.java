package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.AbstractEntity;

public interface IService<T extends AbstractEntity> {

	T getById(int id);

	int insert(T entity);
	
	void update(T entity);

	void saveOrupdate(T entity);

	void delete(int id);

	void delete(T entity);

}
