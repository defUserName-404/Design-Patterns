package org.defusername.creational.builder;

public class RobotEngineer {

	private RobotMaterial robotHead, robotTorso, robotArms, robotLegs;

	public void setRobotHead(RobotMaterial robotHead) {
		this.robotHead = robotHead;
	}

	public void setRobotTorso(RobotMaterial robotTorso) {
		this.robotTorso = robotTorso;
	}

	public void setRobotArms(RobotMaterial robotArms) {
		this.robotArms = robotArms;
	}

	public void setRobotLegs(RobotMaterial robotLegs) {
		this.robotLegs = robotLegs;
	}

	public Robot buildRobot() {
		return (new Robot.Builder()
				.head(robotHead)
				.torso(robotTorso)
				.arms(robotArms)
				.legs(robotLegs)
				.build()
		);
	}
}