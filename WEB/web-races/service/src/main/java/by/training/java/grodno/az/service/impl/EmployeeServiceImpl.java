package by.training.java.grodno.az.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.training.java.grodno.az.data.dao.EmployeeDao;
import by.training.java.grodno.az.data.dao.UserDao;
import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.data.model.User;
import by.training.java.grodno.az.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private UserDao userDao;

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
	public void insertOrUpdate(Employee entity) {
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

	@Override
	public User getUser(int user_id) {
		return userDao.get(user_id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public List<Employee> getAll(String orderBy, boolean orderType) {
		List<Employee> result = employeeDao.getAll(orderBy, orderType);
		return result;
	}

	@Override
	public List<Employee> getAll(Map<String, Object> atributesFinding, String orderBy, boolean type) {
		return employeeDao.getAll(atributesFinding, orderBy, type);
	}

	@Override
	public List<Employee> getAll(int first, int count) {
		List<Employee> result = employeeDao.getAll(first, count);
		return result;
	}

	@Override
	public List<Employee> getAll(int first, int count, String orderBy, boolean orderType) {
		List<Employee> result = employeeDao.getAll(first, count, orderBy, orderType);
		return result;
	}

	@Override
	public List<Employee> getAll(Map<String, Object> atributesFinding, int first, int count, String orderBy,
			boolean orderType) {
		List<Employee> result = employeeDao.getAll(atributesFinding, first, count, orderBy, orderType);
		return result;
	}

	@Override
	public int getCount() {
		return employeeDao.getCount();
	}

	@Override
	public int getCount(Map<String, Object> atributesFinding) {
		return employeeDao.getCount(atributesFinding);
	}

}
