package org.defusername.creational.builder;

public class RobotEngineer {

	private final RobotBuilder robotBuilder;

	public RobotEngineer(RobotBuilder robotBuilder) {
		this.robotBuilder = robotBuilder;
	}

	public Robot getRobot() {
		return robotBuilder.getRobot();
	}

	public void makeRobot() {
		robotBuilder.buildRobotHead();
		robotBuilder.buildRobotTorso();
		robotBuilder.buildRobotArms();
		robotBuilder.buildRobotLegs();
	}
}