package org.example.controller;

import org.example.model.University;
import org.example.model.Faculty;
import org.example.model.Department;
import org.example.model.Group;
import org.example.model.Student;

public class Run {

	public static void main(String[] args) {
		University u = createTypycalUniversity();
		printUniversity(u);
	}

	public static University createTypycalUniversity() {
		HumanCreator humanCreator = new HumanCreator();
		StudentCreator studentCreator = new StudentCreator(humanCreator);
		GroupCreator groupCreator = new GroupCreator(humanCreator, studentCreator);
		DepartmentCreator departmentCreator = new DepartmentCreator(humanCreator, groupCreator);
		FacultyCreator facultyCreator = new FacultyCreator(humanCreator, departmentCreator);
		UniversityCreator universityCreator = new UniversityCreator(humanCreator, facultyCreator);

		return universityCreator.create("Dnipro University", 2, 2, 2, 8);
	}

	private static void printUniversity(University u) {
		System.out.println(u);
		for (Faculty f : u.getFaculties()) {
			System.out.println("  " + f);
			for (Department d : f.getDepartments()) {
				System.out.println("    " + d);
				for (Group g : d.getGroups()) {
					System.out.println("      " + g);
					for (Student s : g.getStudents()) {
						System.out.println("        " + s);
					}
				}
			}
		}
	}
}