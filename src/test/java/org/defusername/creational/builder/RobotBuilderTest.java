package org.defusername.creational.builder;

import org.junit.jupiter.api.*;

class RobotBuilderTest {

	private Robot robot;
	private static RobotEngineer robotEngineer;

	@BeforeAll
	static void beforeAll() {
		robotEngineer = new RobotEngineer();
	}

	@AfterEach
	void tearDown() {
		System.out.println(robot);
	}

	@Test
	@DisplayName("Robot 1")
	void shouldBuildRobot1() {
		robotEngineer.setRobotHead(RobotMaterial.STEEL);
		robotEngineer.setRobotTorso(RobotMaterial.STEEL);
		robotEngineer.setRobotArms(null);
		robot = robotEngineer.buildRobot();
		Assertions.assertEquals(RobotMaterial.STEEL, robot.getRobotHead());
		Assertions.assertEquals(RobotMaterial.STEEL, robot.getRobotTorso());
		Assertions.assertNull(robot.getRobotArms());
		Assertions.assertNull(robot.getRobotLegs());
	}

	@Test
	@DisplayName("Robot 2")
	void shouldBuildRobot2() {
		robotEngineer.setRobotHead(RobotMaterial.STEEL);
		robotEngineer.setRobotTorso(RobotMaterial.ALUMINIUM);
		robotEngineer.setRobotArms(RobotMaterial.ALUMINIUM);
		robotEngineer.setRobotLegs(RobotMaterial.RUBBER_WHEEL);
		robot = robotEngineer.buildRobot();
		Assertions.assertEquals(RobotMaterial.STEEL, robot.getRobotHead());
		Assertions.assertEquals(RobotMaterial.ALUMINIUM, robot.getRobotTorso());
		Assertions.assertEquals(RobotMaterial.ALUMINIUM, robot.getRobotArms());
		Assertions.assertEquals(RobotMaterial.RUBBER_WHEEL, robot.getRobotLegs());
	}
}