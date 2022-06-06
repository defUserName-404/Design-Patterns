package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.DiningTable;

public class VictorianDiningTable implements DiningTable {

	@Override
	public FurnitureMaterial getFurnitureMaterial() {
		return FurnitureMaterial.WOOD;
	}
}