package org.defusername.creational.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SeaLogisticsTest {

	private Logistics logistics;

	@Test
	@DisplayName("Sea Logistics Delivery TC 1")
	void shouldTestDelivery1() {
		logistics = new SeaLogistics("Mobile", DeliverySize.MEDIUM);
		logistics.deliverGoods();
	}

	@Test
	@DisplayName("Sea Logistics Delivery TC 2")
	void shouldTestDelivery2() {
		logistics = new SeaLogistics("Package", DeliverySize.SMALL);
		logistics.deliverGoods();
	}

	@Test
	@DisplayName("Sea Logistics Delivery TC 3")
	void shouldTestDelivery3() {
		logistics = new SeaLogistics("Furniture", DeliverySize.LARGE);
		logistics.deliverGoods();
	}
}