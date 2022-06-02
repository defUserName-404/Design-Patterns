package org.defusername.creational.prototype;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SheepTest {

	private Sheep sheep;

	@BeforeEach
	void setUp() {
		sheep = new Sheep();
	}

	@AfterEach
	void tearDown() {
		sheep = null;
	}

	@Test
	void testClone() {
		sheep.clone();
	}
}