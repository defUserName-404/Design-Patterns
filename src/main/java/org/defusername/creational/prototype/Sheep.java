package org.defusername.creational.prototype;

public class Sheep implements Animal {

	public Sheep() {
		System.out.println("Sheep");
	}

	@Override
	public Animal clone() {
		System.out.println("Sheep Clone");

		Animal sheep;

		try {
			sheep = (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		return sheep;
	}
}