package org.example.db;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

	public static void init(DbConnection db) {
		try (Connection conn = db.getConnection();
		     Statement st = conn.createStatement()) {

			InputStream is = DatabaseInitializer.class
					.getClassLoader()
					.getResourceAsStream("database/database.sql");

			String sql = new String(is.readAllBytes(), StandardCharsets.UTF_8);
			st.executeUpdate(sql);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}