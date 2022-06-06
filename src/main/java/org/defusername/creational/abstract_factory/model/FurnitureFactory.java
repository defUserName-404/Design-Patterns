package org.defusername.creational.abstract_factory.model;

public interface FurnitureFactory {

	Chair createChair();

	DiningTable createDiningTable();

	Sofa createSofa();
}