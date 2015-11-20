package by.epam.andrewzenov.data.dao;

import by.epam.andrewzenov.data.model.Employee;

public interface EmployeeDao {

	Employee getById(int id);
	
	void insert(Employee employee);

	void update(Employee employee);
	
}
