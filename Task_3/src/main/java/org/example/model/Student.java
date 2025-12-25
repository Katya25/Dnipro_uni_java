package org.example.model;

public class Student extends Human {
	private final String name;
	private final Human head;

	public Student(String firstName, String lastName, String patronymic, Sex sex, String name, Human head) {
		super(firstName, lastName, patronymic, sex);
		this.name = name;
		this.head = head;
	}

	public String getName() { return name; }
	public Human getHead() { return head; }

	@Override
	public String toString() {
		String h = (head == null) ? "null" : head.getFullName();
		return "Student{name='" + name + "', human='" + getFullName() + "', head='" + h + "'}";
	}
}