package org.defusername.creational.builder;

public interface RobotBuilder {

	void buildRobotHead();

	void buildRobotTorso();

	void buildRobotArms();

	void buildRobotLegs();

	Robot getRobot();
}