package org.defusername.creational.builder;

import org.junit.jupiter.api.*;

class RobotEngineerTest {

	private RobotBuilder transformersRobotBuilder;
	private RobotEngineer robotEngineer;

	@BeforeEach
	void setUp() {
		transformersRobotBuilder = new TransformerRobotBuilder();
		robotEngineer = new RobotEngineer(transformersRobotBuilder);
	}

	@AfterEach
	void tearDown() {
		transformersRobotBuilder = null;
		robotEngineer = null;
	}

	@Test
	@DisplayName("Transformer Robot Test")
	void shouldTestTransformerRobot() {
		robotEngineer.makeRobot();
		Robot robot = robotEngineer.getRobot();
		Assertions.assertEquals("Metal", robot.getRobotHead());
		Assertions.assertEquals("Metal", robot.getRobotTorso());
		Assertions.assertEquals("Metal", robot.getRobotArms());
		Assertions.assertEquals("Wheels", robot.getRobotLegs());
		System.out.println(robot);
	}
}