package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.Sofa;

public class VictorianSofa implements Sofa {

	@Override
	public FurnitureMaterial getFurnitureMaterial() {
		return FurnitureMaterial.LEATHER;
	}
}