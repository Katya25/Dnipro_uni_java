package org.example.dao;

import org.example.db.DbConnection;
import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentDao {

	private final DbConnection db;

	public JdbcStudentDao(DbConnection db) {
		this.db = db;
	}

	public List<Student> findByBirthMonth(int month) {

		String sql =
				"SELECT * FROM students " +
						"WHERE strftime('%m', birth_date) = ?";

		List<Student> students = new ArrayList<>();

		try (Connection c = db.getConnection();
		     PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setString(1, String.format("%02d", month));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				students.add(new Student(
						rs.getInt("id"),
						rs.getString("record_book_number"),
						rs.getString("last_name"),
						rs.getString("first_name"),
						rs.getString("patronymic"),
						rs.getString("birth_date")
				));
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return students;
	}
}