package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import entities.Stationery;

public class StationeryServes {

	public Stationery createStationery(String name, double cost) {
		return new Stationery(name, cost);
	}

	public Stationery createStationery(int id, String name, double cost, String description) {
		return new Stationery(id, name, cost, description);
	}

	public void addStationery(String name, double cost) {
		String sql = "INSERT INTO stationery(name,cost) VALUES(?,?) ";
		try (Connection con = DBUtil.getConnection()) {
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
		try (Connection con = DBUtil.getConnection()) {
			con.setAutoCommit(false);
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, name);
				ps.setDouble(2, cost);
				ps.setString(3, description);
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
		try (Connection con = DBUtil.getConnection()) {
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

	public List<Stationery> getAllStationery() {
		List<Stationery> list = new ArrayList<>();
		String sql = "select * from stationery";
		try (Connection con = DBUtil.getConnection()) {
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

	public Stationery getStationeryById(int stationery_id) {
		String sql = "select * from stationery where id=?";
		try (Connection con = DBUtil.getConnection()) {
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

}
