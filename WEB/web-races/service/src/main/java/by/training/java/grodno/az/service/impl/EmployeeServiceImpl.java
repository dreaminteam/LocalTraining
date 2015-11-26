package by.training.java.grodno.az.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.EmployeeDao;
import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getById(int id) {
		return employeeDao.get(id);
	}

	@Override
	public int insert(Employee entity) {
		return employeeDao.insert(entity);
	}

	@Override
	public void update(Employee entity) {
		employeeDao.update(entity);
	}

	@Override
	public void saveOrupdate(Employee entity) {
		if (employeeDao.get(entity.getId()) != null) {
			employeeDao.update(entity);
		} else {
			employeeDao.insert(entity);
		}
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
	}

	@Override
	public void delete(Employee entity) {
		employeeDao.delete(entity);
	}

}
