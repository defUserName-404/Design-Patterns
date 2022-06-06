package org.defusername.structural.facade;

public class Circle implements Oval {

	private final double r;

	public Circle(double r) {
		this.r = r;
	}

	@Override
	public double area() {
		return (Math.PI * r * r);
	}
}