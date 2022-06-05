package org.defusername.creational.factory;

public class SeaLogistics implements Logistics {

	private final String goods;
	private final DeliverySize goodSize;

	public SeaLogistics(String goods, DeliverySize goodSize) {
		this.goods = goods;
		this.goodSize = goodSize;
	}

	@Override
	public void deliverGoods() {
		TransportFactory transportFactory = new TransportFactory(this, goodSize);
		Transportation transport = transportFactory.getTransport();
		System.out.println("Delivering " + goods);
		transport.transport();
	}
}