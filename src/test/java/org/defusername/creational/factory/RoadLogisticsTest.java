package org.defusername.creational.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoadLogisticsTest {

	private Logistics logistics;

	@Test
	@DisplayName("Road Logistics Delivery TC 1")
	void shouldTestDelivery1() {
		logistics = new RoadLogistics("Mobile", DeliverySize.MEDIUM);
		logistics.deliverGoods();
	}

	@Test
	@DisplayName("Road Logistics Delivery TC 2")
	void shouldTestDelivery2() {
		logistics = new RoadLogistics("Package", DeliverySize.SMALL);
		logistics.deliverGoods();
	}

	@Test
	@DisplayName("Road Logistics Delivery TC 3")
	void shouldTestDelivery3() {
		logistics = new RoadLogistics("Furniture", DeliverySize.LARGE);
		logistics.deliverGoods();
	}
}