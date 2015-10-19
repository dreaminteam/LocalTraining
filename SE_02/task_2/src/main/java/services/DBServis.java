package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import entities.Employee;

public class DBServis {

	public static void main(String[] args) {
		DBServis servisDB = new DBServis();
		EmployeeServes employeeServes = new EmployeeServes();
		StationeryServes stationeryServes = new StationeryServes();

		/*
		 * employeeServes.addEmployee("Dmitry", "Zenov");
		 * employeeServes.addEmployee("Andrew", "Zenov", "3");
		 * employeeServes.addEmployee("Nikalay", "Batsilou", "developer");
		 */

		/*
		 * stationeryServes.addStationery("pen", 2.3, "black");
		 * stationeryServes.addStationery("pen", 2.5, "red");
		 * stationeryServes.addStationery("pen", 2.1, "blau");
		 * stationeryServes.addStationery("pen", 2.2);
		 */

		/*
		 * employeeServes.addStationeryOnEmployee(1, 1);
		 * employeeServes.addStationeryOnEmployee(1, 2);
		 * employeeServes.addStationeryOnEmployee(2, 2);
		 * employeeServes.addStationeryOnEmployee(2, 3);
		 * employeeServes.addStationeryOnEmployee(3, 1);
		 * employeeServes.addStationeryOnEmployee(3, 2);
		 * employeeServes.addStationeryOnEmployee(3, 3);
		 */

		/*
		 * employeeServes.updatePositionOfEmployee(2, "new position");
		 */

		/*
		 * employeeServes.deleteEmployeeById(1);
		 * 
		 * stationeryServes.deleteStationeryById(2);
		 * employeeServes.deleteStationeryOfEmployee(2, 1);
		 */

		/*
		 * System.out.println(employeeServes.getAllEmployees().toString());
		 * System.out.println(stationeryServes.getAllStationery().toString());
		 */

		Employee employee = employeeServes.getEmployeeById(1);

		Double sum = employeeServes.getRusultCostOfStationery(employee);
		System.out.println(sum);

	}

	private static final String USER_LOGIN = "root";
	private static final String USER_PASSWORD = "135246";
	private static final String MY_CONNECTION_URL = "jdbc:mysql://localhost:3306/office";

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(MY_CONNECTION_URL, USER_LOGIN, USER_PASSWORD);
		return con;
	}

}
