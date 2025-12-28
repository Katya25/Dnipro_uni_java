package org.example.model;

import java.util.Objects;

public class Student extends Human {
	private String name;
	private Human head;

	public Student() {
	}

	public Student(String firstName, String lastName, String patronymic, Sex sex, String name, Human head) {
		super(firstName, lastName, patronymic, sex);
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;
		if (!super.equals(o)) return false;
		Student student = (Student) o;
		return Objects.equals(name, student.name)
				&& Objects.equals(head, student.head);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), name, head);
	}
}