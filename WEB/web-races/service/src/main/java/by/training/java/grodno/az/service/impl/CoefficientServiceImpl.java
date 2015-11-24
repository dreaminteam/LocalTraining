package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.CoefficientDao;
import by.training.java.grodno.az.data.model.Coefficient;
import by.training.java.grodno.az.service.CoefficientService;

@Service
public class CoefficientServiceImpl implements CoefficientService{

	@Autowired
	private CoefficientDao coefficientDao;
	
	@Override
	public Coefficient getById(int id) {
		return coefficientDao.get(id);
	}

	@Override
	public void insert(Coefficient persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Coefficient persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Coefficient persistent) {
		// TODO Auto-generated method stub
		
	}

	

}
