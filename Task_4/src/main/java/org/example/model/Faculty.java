package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
	private String name;
	private Human head;
	private List<Department> departments = new ArrayList<>();

	public Faculty() {
	}

	public Faculty(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Department> getDepartments() { return departments; }

	public void addDepartment(Department d) { departments.add(d); }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Faculty)) return false;
		Faculty faculty = (Faculty) o;
		return Objects.equals(name, faculty.name)
				&& Objects.equals(head, faculty.head)
				&& Objects.equals(departments, faculty.departments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, head, departments);
	}
}