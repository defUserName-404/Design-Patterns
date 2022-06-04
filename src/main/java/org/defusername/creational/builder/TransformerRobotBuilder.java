package org.defusername.creational.builder;

public class TransformerRobotBuilder implements RobotBuilder {

	private final Robot robot;

	public TransformerRobotBuilder() {
		this.robot = new Robot();
	}

	@Override
	public void buildRobotHead() {
		robot.setRobotHead("Metal");
	}

	@Override
	public void buildRobotTorso() {
		robot.setRobotTorso("Metal");
	}

	@Override
	public void buildRobotArms() {
		robot.setRobotArms("Metal");
	}

	@Override
	public void buildRobotLegs() {
		robot.setRobotLegs("Wheels");
	}

	@Override
	public Robot getRobot() {
		return robot;
	}
}