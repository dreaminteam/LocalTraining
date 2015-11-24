package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.impl.GenericDao;
import by.training.java.grodno.az.service.AbstractService;

//@Service
public  class AbstractServiceImpl<T> implements AbstractService<T>{

//	@Autowired
	private GenericDao<T> abstractDao;
	
	@Override
	public T getById(int id) {
		return abstractDao.get(id);
	}

	@Override
	public void insert(T persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T persistent) {
		// TODO Auto-generated method stub
		
	}

	
	
}
