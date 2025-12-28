package org.example.controller;

import org.example.model.Faculty;
import org.example.model.Department;
import org.example.model.Human;

public class FacultyCreator extends AbstractCreator implements Creator<Faculty> {

	private final HumanCreator humanCreator;
	private final DepartmentCreator departmentCreator;

	public FacultyCreator(HumanCreator humanCreator, DepartmentCreator departmentCreator) {
		this.humanCreator = humanCreator;
		this.departmentCreator = departmentCreator;
	}

	public Faculty create(String name, int departmentsCount, int groupsPerDept, int studentsPerGroup) {
		Human head = humanCreator.create();
		Faculty f = new Faculty(name, head);
		for (int i = 0; i < departmentsCount; i++) {
			Department d = departmentCreator.create(name + "-Dept" + (i + 1), groupsPerDept, studentsPerGroup);
			f.addDepartment(d);
		}
		return f;
	}

	@Override
	public Faculty create() {
		return create("Faculty-" + (1 + rnd.nextInt(10)), 2, 2, 10);
	}
}