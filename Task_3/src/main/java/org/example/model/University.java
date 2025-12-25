package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class University {
	private final String name;
	private final Human head;
	private final List<Faculty> faculties = new ArrayList<>();

	public University(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Faculty> getFaculties() { return faculties; }

	public void addFaculty(Faculty f) {
		faculties.add(f);
	}

	@Override
	public String toString() {
		return "University{name='" + name + "', head='" + head.getFullName() + "', faculties=" + faculties.size() + "}";
	}
}