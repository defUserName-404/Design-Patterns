package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.Chair;

public class VictorianChair implements Chair {

	@Override
	public FurnitureMaterial getFurnitureMaterial() {
		return FurnitureMaterial.WOOD;
	}
}