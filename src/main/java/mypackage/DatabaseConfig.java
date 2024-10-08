package mypackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

	// Define database parameters
	private static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
	private static final String HOST = "localhost";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Ujjwal@151#";
	private static final String DB_NAME = "chat";
	private static final int PORT_NO = 3306;

	// Connection URL
	private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT_NO + "/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
	private Connection conn = null;

	// Constructor to establish the connection
	public DatabaseConfig() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_PATH);
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// Method to close the connection
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace(); // Handle the exception appropriately
			}
		}
	}

	// Getter for the connection
	public Connection getConnection() {
		return conn;
	}
}
