package org.defusername.creational.builder;

public class Robot {

	private final RobotMaterial robotHead, robotTorso, robotArms, robotLegs;

	private Robot(Builder builder) {
		this.robotHead = builder.robotHead;
		this.robotTorso = builder.robotTorso;
		this.robotArms = builder.robotArms;
		this.robotLegs = builder.robotLegs;
	}

	public RobotMaterial getRobotHead() {
		return robotHead;
	}

	public RobotMaterial getRobotTorso() {
		return robotTorso;
	}

	public RobotMaterial getRobotArms() {
		return robotArms;
	}

	public RobotMaterial getRobotLegs() {
		return robotLegs;
	}

	@Override
	public String toString() {
		return "[head=" +
				robotHead +
				",torso=" +
				robotTorso +
				",arms=" +
				robotArms +
				",legs=" +
				robotLegs +
				"]";
	}

	public static class Builder {

		private RobotMaterial robotHead, robotTorso, robotArms, robotLegs;

		public Builder head(RobotMaterial head) {
			this.robotHead = head;
			return this;
		}

		public Builder torso(RobotMaterial torso) {
			this.robotTorso = torso;
			return this;
		}

		public Builder arms(RobotMaterial arms) {
			this.robotArms = arms;
			return this;
		}

		public Builder legs(RobotMaterial legs) {
			this.robotLegs = legs;
			return this;
		}

		public Robot build() {
			return new Robot(this);
		}
	}
}