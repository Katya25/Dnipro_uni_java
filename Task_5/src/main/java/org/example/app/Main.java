package org.example.app;

import org.example.dao.JdbcStudentDao;
import org.example.db.DatabaseInitializer;
import org.example.db.DbConnection;
import org.example.model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		DbConnection db = new DbConnection();
		DatabaseInitializer.init(db);

		JdbcStudentDao dao = new JdbcStudentDao(db);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter month (1-12): ");
		int month = sc.nextInt();

		List<Student> students = dao.findByBirthMonth(month);

		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			students.forEach(System.out::println);
		}
	}
}