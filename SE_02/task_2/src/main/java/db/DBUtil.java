package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USER_LOGIN = "root";
	private static final String USER_PASSWORD = "135246";
	private static final String MY_CONNECTION_URL = "jdbc:mysql://localhost:3306/office";

	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(MY_CONNECTION_URL, USER_LOGIN, USER_PASSWORD);
		return con;
	}

}
