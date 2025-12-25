package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private final String name;
	private final Human head;
	private final List<Group> groups = new ArrayList<>();

	public Department(String name, Human head) {
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }
	public List<Group> getGroups() { return groups; }

	public void addGroup(Group g) {
		groups.add(g);
	}

	@Override
	public String toString() {
		return "Department{name='" + name + "', head='" + head.getFullName() + "', groups=" + groups.size() + "}";
	}
}