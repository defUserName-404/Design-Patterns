package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.Sofa;

public class ArtDecoSofa implements Sofa {

	@Override
	public FurnitureMaterial getFurnitureMaterial() {
		return FurnitureMaterial.LEATHER;
	}
}