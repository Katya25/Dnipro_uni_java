package org.example.controller;

import org.example.model.Department;
import org.example.model.Group;
import org.example.model.Human;

public class DepartmentCreator extends AbstractCreator implements Creator<Department> {

	private final HumanCreator humanCreator;
	private final GroupCreator groupCreator;

	public DepartmentCreator(HumanCreator humanCreator, GroupCreator groupCreator) {
		this.humanCreator = humanCreator;
		this.groupCreator = groupCreator;
	}

	public Department create(String name, int groupsCount, int studentsPerGroup) {
		Human head = humanCreator.create();
		Department d = new Department(name, head);
		for (int i = 0; i < groupsCount; i++) {
			Group g = groupCreator.create(name + "-G" + (i + 1), studentsPerGroup);
			d.addGroup(g);
		}
		return d;
	}

	@Override
	public Department create() {
		return create("Dept-" + (1 + rnd.nextInt(20)), 2, 10);
	}
}