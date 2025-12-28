package org.example.controller;

import org.example.model.Human;
import org.example.model.Person;
import org.example.model.Student;

public class StudentCreator extends AbstractCreator implements Creator<Student> {

	private final HumanCreator humanCreator;

	public StudentCreator(HumanCreator humanCreator) {
		this.humanCreator = humanCreator;
	}

	@Override
	public Student create() {
		Person base = humanCreator.create();
		String name = base.getLastName() + " " + base.getFirstName();
		Human head = null;
		return new Student(base.getFirstName(), base.getLastName(), base.getPatronymic(), base.getSex(), name, head);
	}
}