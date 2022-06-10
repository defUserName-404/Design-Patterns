package org.defusername.creational.builder;

public class Robot {

	private final String robotHead, robotTorso, robotArms, robotLegs;

	private Robot(Builder builder) {
		this.robotHead = builder.robotHead;
		this.robotTorso = builder.robotTorso;
		this.robotArms = builder.robotArms;
		this.robotLegs = builder.robotLegs;
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

	public static class Builder {

		private String robotHead, robotTorso, robotArms, robotLegs;

		public Builder head(String head) {
			this.robotHead = head;
			return this;
		}

		public Builder torso(String torso) {
			this.robotTorso = torso;
			return this;
		}

		public Builder arms(String arms) {
			this.robotArms = arms;
			return this;
		}

		public Builder legs(String legs) {
			this.robotLegs = legs;
			return this;
		}

		public Robot build() {
			return new Robot(this);
		}
	}
}