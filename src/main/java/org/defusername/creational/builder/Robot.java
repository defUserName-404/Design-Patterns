package org.defusername.creational.builder;

public class Robot {

	private final String robotHead, robotTorso, robotArms, robotLegs;

	private Robot(RobotBuilder robotBuilder) {
		this.robotHead = robotBuilder.robotHead;
		this.robotTorso = robotBuilder.robotTorso;
		this.robotArms = robotBuilder.robotArms;
		this.robotLegs = robotBuilder.robotLegs;
	}

	public String getRobotHead() {
		return robotHead;
	}

	public String getRobotTorso() {
		return robotTorso;
	}

	public String getRobotArms() {
		return robotArms;
	}

	public String getRobotLegs() {
		return robotLegs;
	}

	@Override
	public String toString() {
		return "[head=" +
				getRobotHead() +
				",torso=" +
				getRobotTorso() +
				",arms=" +
				getRobotArms() +
				",legs=" +
				getRobotLegs() +
				"]";
	}

	public static class RobotBuilder {

		private String robotHead, robotTorso, robotArms, robotLegs;

		private RobotBuilder() {
		}

		public static RobotBuilder createNewRobotBuilder() {
			return new RobotBuilder();
		}

		public RobotBuilder head(String head) {
			this.robotHead = head;
			return this;
		}

		public RobotBuilder torso(String torso) {
			this.robotTorso = torso;
			return this;
		}

		public RobotBuilder arms(String arms) {
			this.robotArms = arms;
			return this;
		}

		public RobotBuilder legs(String legs) {
			this.robotLegs = legs;
			return this;
		}

		public Robot build() {
			return new Robot(this);
		}
	}
}