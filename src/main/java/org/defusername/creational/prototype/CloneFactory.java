package org.defusername.creational.prototype;

public class CloneFactory {

	public Animal getClone(Animal animalSample) {
		return animalSample.clone();
	}
}