package org.defusername.structural.facade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AreaCalculatorTest {

	private final AreaCalculator areaCalculator = new AreaCalculator();

	@Test
	@DisplayName("Circle Test")
	void shouldCalculateArea1() {
		double radius = 3.2;
		TwoDimensionalShape circle = new Circle(radius);
		double area = areaCalculator.calculateArea(circle);

		Assertions.assertEquals(Math.PI * radius * radius, area);
	}

	@Test
	@DisplayName("Triangle Test")
	void shouldCalculateArea2() {
		double a = 6, b = 8, c = 10;
		double s = (a + b + c) / 2;
		TwoDimensionalShape triangle = new Triangle(a, b, c);
		double area = areaCalculator.calculateArea(triangle);

		Assertions.assertEquals(Math.sqrt(s * (s - a) * (s - b) * (s - c)), area);
	}

	@Test
	@DisplayName("Rectangle Test")
	void shouldCalculateArea3() {
		double x = 8, y = 12;
		TwoDimensionalShape rectangle = new Rectangle(x, y);
		double area = areaCalculator.calculateArea(rectangle);

		Assertions.assertEquals(x * y, area);
	}
}