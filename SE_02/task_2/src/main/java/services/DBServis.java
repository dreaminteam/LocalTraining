package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;
import entities.Stationery;

public class DBServis {

	public static void main(String[] args) {
		DBServis servisDB = new DBServis();
		EmployeeServes employeeServes=new EmployeeServes();
		/*
		 * servisDB.addEmployee("Dmitry", "Zenov");
		 * servisDB.addEmployee("Andrew", "Zenov", "3");
		 * servisDB.addEmployee("Nikalay", "Batsilou", "developer");
		 * servisDB.addStationery("pen", 2.3, "black");
		 * servisDB.addStationery("pen", 2.5, "red");
		 * servisDB.addStationery("pen", 2.1, "blau");
		 * servisDB.addStationery("pen", 2.2);
		 */
		// System.out.print(servisDB.getEmployeeById(3));
		// servisDB.deleteStationeryById(2);

		//System.out.println(servisDB.getStationeryById(1).toString());
		//System.out.println(servisDB.getAllEmployees().toString());
		//System.out.println(servisDB.getAllStationery().toString());
		
		Employee employee=servisDB.getEmployeeById(1);
		System.out.println(employeeServes.getRusultCostOfStationery(employee));
		
	}

	private String userLogin = "root";
	private String userPassword = "135246";
	private String myConnectioURL = "jdbc:mysql://localhost:3306/office";
	// private String driverName = "com.mysql.jdbc.Driver";

	public void addEmployee(String name, String surName) {
		String sql = "INSERT INTO employee(name,surname,position) VALUES(?,?) ";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, name);
				ps.setString(2, surName);
				ps.executeUpdate();
			} catch (SQLException ex) {
				con.rollback();
				con.setAutoCommit(true);
				ex.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addEmployee(String name, String surName, String position) {
		String sql = "INSERT INTO employee(name,surname,position) VALUES(?,?,?) ";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, name);
				ps.setString(2, surName);
				ps.setString(3, position);
				ps.executeUpdate();
			} catch (SQLException ex) {
				con.rollback();
				con.setAutoCommit(true);
				ex.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStationery(String name, double cost) {
		String sql = "INSERT INTO stationery(name,cost) VALUES(?,?) ";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, name);
				ps.setDouble(2, cost);
				ps.executeUpdate();
			} catch (SQLException ex) {
				con.rollback();
				con.setAutoCommit(true);
				ex.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStationery(String name, double cost, String description) {
		String sql = "INSERT INTO stationery(name,cost,description) VALUES(?,?,?) ";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, name);
				ps.setDouble(2, cost);
				ps.setString(1, description);
				ps.executeUpdate();
			} catch (SQLException ex) {
				con.rollback();
				con.setAutoCommit(true);
				ex.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployeeById(int employee_id) {
		String sql = "DELETE FROM employee where id=?";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, employee_id);
				ps.executeUpdate();
			} catch (SQLException ex) {
				con.rollback();
				con.setAutoCommit(true);
				ex.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStationeryById(int stationery_id) {
		String sql = "DELETE FROM stationery where id=?";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, stationery_id);
				ps.executeUpdate();
			} catch (SQLException ex) {
				con.rollback();
				con.setAutoCommit(true);
				ex.printStackTrace();
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Return all employees without stationery.
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		String sql = "select * from employee";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			PreparedStatement ps = con.prepareStatement(sql);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {

					EmployeeServes employeeServes = new EmployeeServes();

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surName = rs.getString("surname");
					String position = rs.getString("position");
					Employee employee = employeeServes.createEmployee(id, name, surName, position);
					list.add(employee);

				}
				System.out.println(list.size());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public List getAllStationery() {
		List<Stationery> list = new ArrayList<>();
		String sql = "select * from stationery";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			PreparedStatement ps = con.prepareStatement(sql);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					StationeryServes stationeryServes = new StationeryServes();

					int id = rs.getInt("id");
					String name = rs.getString("name");
					Double cost = rs.getDouble("cost");
					String description = rs.getString("description");
					Stationery stationery = stationeryServes.createStationery(id, name, cost, description);
					list.add(stationery);

				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public Employee getEmployeeById(int employee_id) {
		String sql = "select * from employee where id=?";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employee_id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					EmployeeServes employeeServes = new EmployeeServes();

					int id = rs.getInt("id");
					String name = rs.getString("name");
					String surName = rs.getString("surname");
					String position = rs.getString("position");
					ArrayList<Stationery> list = (ArrayList<Stationery>) getStationeryOfEmployeeById(employee_id);

					Employee employee = new Employee(id, name, surName, position);
					employee.setList(list);
					return employee;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Stationery getStationeryById(int stationery_id) {
		String sql = "select * from stationery where id=?";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, stationery_id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					StationeryServes stationeryServes = new StationeryServes();

					int id = rs.getInt("id");
					String name = rs.getString("name");
					Double cost = rs.getDouble("cost");
					String description = rs.getString("description");

					Stationery stationery = stationeryServes.createStationery(id, name, cost, description);
					return stationery;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private List getStationeryOfEmployeeById(int employee_id) {
		List<Stationery> list = new ArrayList<>();
		String sql = "select id,name,cost,description"
				+ " from stationery join employee_has_stationery on id=stationery_id" + " where employee_id=?";
		try (Connection con = DriverManager.getConnection(myConnectioURL, userLogin, userPassword)) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, employee_id);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					StationeryServes stationeryServes = new StationeryServes();
					int id = rs.getInt("id");
					String name = rs.getString("name");
					Double cost = rs.getDouble("cost");
					String description = rs.getString("description");
					list.add(stationeryServes.createStationery(id, name, cost, description));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
