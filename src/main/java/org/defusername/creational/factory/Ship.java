package org.defusername.creational.factory;

public class Ship implements Transportation {

	@Override
	public void transport() {
		System.out.println("Transporting by a ship");
	}
}