package org.defusername.creational.factory;

public class PickupTruck extends Truck {

	@Override
	public void transport() {
		System.out.println("Transporting by a pickup truck");
	}
}