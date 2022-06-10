package org.defusername.creational.builder;

public class RobotEngineer {

	private String robotHead, robotTorso, robotArms, robotLegs;

	public void setRobotHead(String robotHead) {
		this.robotHead = robotHead;
	}

	public void setRobotTorso(String robotTorso) {
		this.robotTorso = robotTorso;
	}

	public void setRobotArms(String robotArms) {
		this.robotArms = robotArms;
	}

	public void setRobotLegs(String robotLegs) {
		this.robotLegs = robotLegs;
	}

	public void buildRobot() {
		Robot robot = new Robot.Builder()
				.head(robotHead)
				.torso(robotTorso)
				.arms(robotArms)
				.legs(robotLegs)
				.build();

		System.out.println(robot);
	}
}