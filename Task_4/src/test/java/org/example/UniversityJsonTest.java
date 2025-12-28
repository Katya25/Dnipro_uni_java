package org.example;

import org.example.controller.JsonManager;
import org.example.model.*;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityJsonTest {

	@Test
	void universityJsonRoundTrip_equalsTrue() throws Exception {
		University oldUniversity = createUniversity2x2x2x2();

		Path tempFile = Files.createTempFile("university", ".json");
		try {
			JsonManager jm = new JsonManager();
			jm.writeToFile(tempFile, oldUniversity);

			University newUniversity = jm.readFromFile(tempFile);

			assertEquals(oldUniversity, newUniversity);
		} finally {
			Files.deleteIfExists(tempFile);
		}
	}

	private University createUniversity2x2x2x2() {
		Human uniHead = new Human("Ivan", "Shevchenko", "Ivanovych", Sex.MALE);
		University u = new University("Test University", uniHead);

		for (int f = 1; f <= 2; f++) {
			Human facultyHead = new Human("Olena", "Koval" + f, "Petrivna", Sex.FEMALE);
			Faculty faculty = new Faculty("Faculty-" + f, facultyHead);

			for (int d = 1; d <= 2; d++) {
				Human deptHead = new Human("Taras", "Melnyk" + d, "Andriyovych", Sex.MALE);
				Department dept = new Department("Department-" + f + "-" + d, deptHead);

				for (int g = 1; g <= 2; g++) {
					Human groupHead = new Human("Iryna", "Bondarenko" + g, "Ivanivna", Sex.FEMALE);
					Group group = new Group("Group-" + f + "-" + d + "-" + g, groupHead);

					for (int s = 1; s <= 2; s++) {
						Student st = new Student(
								"Sofia",
								"Student" + f + d + g + s,
								"Petrovna",
								Sex.FEMALE,
								"StudentName-" + f + d + g + s,
								groupHead
						);
						group.addStudent(st);
					}

					dept.addGroup(group);
				}

				faculty.addDepartment(dept);
			}

			u.addFaculty(faculty);
		}

		return u;
	}
}