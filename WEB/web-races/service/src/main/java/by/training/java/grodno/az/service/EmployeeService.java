package by.training.java.grodno.az.service;

import by.training.java.grodno.az.data.model.Employee;
import by.training.java.grodno.az.data.model.User;

public interface EmployeeService extends IService<Employee> {

	User getUser(int user_id);
	
}
