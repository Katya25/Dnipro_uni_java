package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
	private String name;
	private Human head;
	private List<Faculty> faculties = new ArrayList<>();

	public University() {
	}

	public University(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Faculty> getFaculties() { return faculties; }

	public void addFaculty(Faculty f) { faculties.add(f); }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof University)) return false;
		University that = (University) o;
		return Objects.equals(name, that.name)
				&& Objects.equals(head, that.head)
				&& Objects.equals(faculties, that.faculties);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, head, faculties);
	}
}