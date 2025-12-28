package org.example.model;

public class Student {

	private final int id;
	private final String recordBookNumber;
	private final String lastName;
	private final String firstName;
	private final String patronymic;
	private final String birthDate;

	public Student(int id, String recordBookNumber, String lastName,
	               String firstName, String patronymic, String birthDate) {
		this.id = id;
		this.recordBookNumber = recordBookNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.patronymic = patronymic;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return id + " | " + recordBookNumber + " | " +
				lastName + " " + firstName + " " + patronymic +
				" | " + birthDate;
	}
}