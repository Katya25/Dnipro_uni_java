package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String URL = "jdbc:sqlite:students.db";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("SQLite JDBC driver not found", e);
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL);
	}
}