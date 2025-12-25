package org.example.controller;

import org.example.model.Group;
import org.example.model.Human;
import org.example.model.Student;

public class GroupCreator extends AbstractCreator implements Creator<Group> {

	private final HumanCreator humanCreator;
	private final StudentCreator studentCreator;

	public GroupCreator(HumanCreator humanCreator, StudentCreator studentCreator) {
		this.humanCreator = humanCreator;
		this.studentCreator = studentCreator;
	}

	public Group create(String groupName, int studentsCount) {
		Human head = humanCreator.create();
		Group g = new Group(groupName, head);
		for (int i = 0; i < studentsCount; i++) {
			Student s = studentCreator.create();
			g.addStudent(s);
		}
		return g;
	}

	@Override
	public Group create() {
		return create("GR-" + (100 + rnd.nextInt(900)), 10);
	}
}