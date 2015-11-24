package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.EmployeeDao;
import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee getById(int id) {
		return employeeDao.get(id);
	}

}
