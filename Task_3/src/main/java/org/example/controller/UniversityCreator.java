package org.example.controller;

import org.example.model.University;
import org.example.model.Faculty;
import org.example.model.Human;

public class UniversityCreator extends AbstractCreator implements Creator<University> {

	private final HumanCreator humanCreator;
	private final FacultyCreator facultyCreator;

	public UniversityCreator(HumanCreator humanCreator, FacultyCreator facultyCreator) {
		this.humanCreator = humanCreator;
		this.facultyCreator = facultyCreator;
	}

	public University create(String name, int facultiesCount, int departmentsPerFaculty, int groupsPerDept, int studentsPerGroup) {
		Human head = humanCreator.create();
		University u = new University(name, head);
		for (int i = 0; i < facultiesCount; i++) {
			Faculty f = facultyCreator.create("Faculty-" + (i + 1), departmentsPerFaculty, groupsPerDept, studentsPerGroup);
			u.addFaculty(f);
		}
		return u;
	}

	@Override
	public University create() {
		return create("Typical University", 2, 2, 2, 10);
	}
}