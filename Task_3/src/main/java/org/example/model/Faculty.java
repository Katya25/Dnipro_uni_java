package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
	private final String name;
	private final Human head;
	private final List<Department> departments = new ArrayList<>();

	public Faculty(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Department> getDepartments() { return departments; }

	public void addDepartment(Department d) {
		departments.add(d);
	}

	@Override
	public String toString() {
		return "Faculty{name='" + name + "', head='" + head.getFullName() + "', departments=" + departments.size() + "}";
	}
}