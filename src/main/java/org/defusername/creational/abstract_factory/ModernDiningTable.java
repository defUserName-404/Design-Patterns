package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.DiningTable;

public class ModernDiningTable implements DiningTable {

	@Override
	public FurnitureMaterial getFurnitureMaterial() {
		return FurnitureMaterial.PLASTIC;
	}
}