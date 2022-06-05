package org.defusername.creational.factory;

public class Truck implements Transportation {

	@Override
	public void transport() {
		System.out.println("Transporting by a truck");
	}
}