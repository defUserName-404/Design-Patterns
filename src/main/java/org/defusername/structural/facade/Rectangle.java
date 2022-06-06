package org.defusername.structural.facade;

public class Rectangle implements Polygon {

	private final double x, y;

	public Rectangle(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double area() {
		return (x * y);
	}
}