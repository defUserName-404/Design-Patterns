package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.Chair;
import org.defusername.creational.abstract_factory.model.DiningTable;
import org.defusername.creational.abstract_factory.model.FurnitureFactory;
import org.defusername.creational.abstract_factory.model.Sofa;

public class ArtDecoFurnitureFactory implements FurnitureFactory {

	@Override
	public Chair createChair() {
		return new ArtDecoChair();
	}

	@Override
	public DiningTable createDiningTable() {
		return new ArtDecoDiningTable();
	}

	@Override
	public Sofa createSofa() {
		return new ArtDecoSofa();
	}
}