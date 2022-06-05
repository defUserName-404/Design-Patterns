package org.defusername.creational.factory;

public class TransportFactory {

	private Transportation transport;
	private final Logistics logistics;
	private final DeliverySize deliverySize;

	public TransportFactory(Logistics logistics, DeliverySize deliverySize) {
		this.logistics = logistics;
		this.deliverySize = deliverySize;
	}

	public Transportation getTransport() {
		if (logistics instanceof RoadLogistics) {
			if (deliverySize == DeliverySize.SMALL)
				transport = new PickupTruck();
			else
				transport = new Truck();
		} else if (logistics instanceof SeaLogistics)
			transport = new Ship();

		return transport;
	}
}