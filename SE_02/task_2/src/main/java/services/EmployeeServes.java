package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
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

	public void addEmployee(String name, String surName) {
		String sql = "INSERT INTO employee(name,surname,position) VALUES(?,?) ";
		try (Connection con = DBUtil.getConnection()) {
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
		try (Connection con = DBUtil.getConnection()) {
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

	public void addStationeryOnEmployee(int employee_id, int stationery_id) {
		String sql = "INSERT INTO employee_has_stationery VALUES(?,?)";
		try (Connection con = DBUtil.getConnection()) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, employee_id);
				ps.setInt(2, stationery_id);
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

	public void updatePositionOfEmployee(int employee_id, String newPosition) {
		String sql = "UPDATE employee SET position=? where id=?";
		try (Connection con = DBUtil.getConnection()) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, newPosition);
				ps.setInt(2, employee_id);
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
		try (Connection con = DBUtil.getConnection()) {
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

	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		String sql = "select * from employee";
		try (Connection con = DBUtil.getConnection()) {
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

	public Employee getEmployeeById(int employee_id) {
		String sql = "select * from employee where id=?";
		try (Connection con = DBUtil.getConnection()) {
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

					Employee employee = employeeServes.createEmployee(id, name, surName, position);
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

	private List<Stationery> getStationeryOfEmployeeById(int employee_id) {
		List<Stationery> list = new ArrayList<>();
		String sql = "select id,name,cost,description"
				+ " from stationery join employee_has_stationery on id=stationery_id" + " where employee_id=?";
		try (Connection con = DBUtil.getConnection()) {
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

	public void deleteStationeryOfEmployee(int employee_id, int stationery_id) {
		String sql = "DELETE FROM employee_has_stationery where employee_id=? and stationery_id=?";
		try (Connection con = DBUtil.getConnection()) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, employee_id);
				ps.setInt(2, stationery_id);
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

}
