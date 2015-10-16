package services;

import entities.Employee;
import entities.Stationery;

public class EmployeeServes {

	public Employee createEmployee(String name, String surName, String position) {
		return new Employee(name, surName, position);
	}

	public Employee createEmployee(int id, String name, String surName, String position) {
		return new Employee(id, name, surName, position);
	}

	public Double getRusultCostOfStationery(Employee employee) {
		Double result = 0.0;
		for (Stationery stationery : employee.getList()) {
			result += stationery.getCost();
		}
		return result;
	}

}
