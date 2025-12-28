package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
	private String name;
	private Human head;
	private List<Student> students = new ArrayList<>();

	public Group() {
	}

	public Group(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Student> getStudents() { return students; }

	public void addStudent(Student s) { students.add(s); }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Group)) return false;
		Group group = (Group) o;
		return Objects.equals(name, group.name)
				&& Objects.equals(head, group.head)
				&& Objects.equals(students, group.students);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, head, students);
	}
}