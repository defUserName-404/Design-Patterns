package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.DiningTable;

public class ArtDecoDiningTable implements DiningTable {

	@Override
	public FurnitureMaterial getFurnitureMaterial() {
		return FurnitureMaterial.GLASS;
	}
}