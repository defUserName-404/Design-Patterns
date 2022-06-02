package org.defusername.creational.prototype;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CloneFactoryTest {

	private final CloneFactory animalCloner = new CloneFactory();

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void getClone() {
		Animal sheep = new Sheep();
		Animal clonedSheep = animalCloner.getClone(sheep);

		System.out.println(sheep.hashCode());
		System.out.println(clonedSheep.hashCode());
	}
}