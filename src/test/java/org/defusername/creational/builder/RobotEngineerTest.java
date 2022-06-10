package org.defusername.creational.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RobotEngineerTest {

	@Test
	@DisplayName("Robot 1")
	void shouldBuildRobot1() {
		RobotEngineer robotEngineer = new RobotEngineer();
		robotEngineer.setRobotHead("Metal");
		robotEngineer.setRobotArms("Tin");
		robotEngineer.setRobotLegs(null);
		robotEngineer.buildRobot();
	}
}