package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.Chair;
import org.defusername.creational.abstract_factory.model.DiningTable;
import org.defusername.creational.abstract_factory.model.FurnitureFactory;
import org.defusername.creational.abstract_factory.model.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {

	@Override
	public Chair createChair() {
		return new ModernChair();
	}

	@Override
	public DiningTable createDiningTable() {
		return new ModernDiningTable();
	}

	@Override
	public Sofa createSofa() {
		return new ModernSofa();
	}
}