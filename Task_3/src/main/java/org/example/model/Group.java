package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private final String name;
	private final Human head;
	private final List<Student> students = new ArrayList<>();

	public Group(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Student> getStudents() { return students; }

	public void addStudent(Student s) {
		students.add(s);
	}

	@Override
	public String toString() {
		return "Group{name='" + name + "', head='" + head.getFullName() + "', students=" + students.size() + "}";
	}
}