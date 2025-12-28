package org.example.controller;

import org.example.model.Person;
import org.example.model.Sex;

public class HumanCreator extends AbstractCreator implements Creator<Person> {

	private static final String[] FIRST = {"Ivan", "Olena", "Taras", "Iryna", "Maksym", "Sofia"};
	private static final String[] LAST = {"Shevchenko", "Koval", "Melnyk", "Bondarenko", "Tkachenko", "Kravchenko"};
	private static final String[] PATR = {"Ivanovych", "Petrovych", "Andriyovych", "Ivanivna", "Petrivna", "Andriyivna"};

	@Override
	public Person create() {
		String first = FIRST[rnd.nextInt(FIRST.length)];
		String last = LAST[rnd.nextInt(LAST.length)];
		String patr = PATR[rnd.nextInt(PATR.length)];
		Sex sex = rnd.nextBoolean() ? Sex.MALE : Sex.FEMALE;
		return new Person(first, last, patr, sex);
	}
}