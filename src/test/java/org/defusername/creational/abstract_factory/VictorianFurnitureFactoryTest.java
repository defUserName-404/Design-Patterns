package org.defusername.creational.abstract_factory;

import org.defusername.creational.abstract_factory.model.Chair;
import org.defusername.creational.abstract_factory.model.DiningTable;
import org.defusername.creational.abstract_factory.model.FurnitureFactory;
import org.defusername.creational.abstract_factory.model.Sofa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VictorianFurnitureFactoryTest {

	private final FurnitureFactory furnitureFactory = new VictorianFurnitureFactory();

	@Test
	@DisplayName("Chair Test")
	void shouldTestChair() {
		Chair chair = furnitureFactory.createChair();
		FurnitureMaterial furnitureMaterial = chair.getFurnitureMaterial();

		Assertions.assertEquals(FurnitureMaterial.WOOD, furnitureMaterial);
	}

	@Test
	@DisplayName("Dining Table Test")
	void shouldTestDiningTable() {
		DiningTable diningTable = furnitureFactory.createDiningTable();
		FurnitureMaterial furnitureMaterial = diningTable.getFurnitureMaterial();

		Assertions.assertEquals(FurnitureMaterial.WOOD, furnitureMaterial);
	}

	@Test
	@DisplayName("Sofa Test")
	void shouldTestSofa() {
		Sofa diningTable = furnitureFactory.createSofa();
		FurnitureMaterial furnitureMaterial = diningTable.getFurnitureMaterial();

		Assertions.assertEquals(FurnitureMaterial.LEATHER, furnitureMaterial);
	}
}