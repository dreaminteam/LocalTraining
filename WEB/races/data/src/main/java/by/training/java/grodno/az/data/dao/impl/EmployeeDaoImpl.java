package by.training.java.grodno.az.data.dao.impl;

import org.springframework.stereotype.Repository;

import by.training.java.grodno.az.data.dao.Dao;
import by.training.java.grodno.az.data.dao.EmployeeDao;
import by.training.java.grodno.az.data.model.Employee;

@Repository
public class EmployeeDaoImpl implements Dao<Employee>,EmployeeDao {

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Employee persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrupdate(Employee persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee persistent) {
		// TODO Auto-generated method stub
		
	}

}
