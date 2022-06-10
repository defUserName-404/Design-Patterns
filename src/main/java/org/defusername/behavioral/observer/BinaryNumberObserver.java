package org.defusername.behavioral.observer;

public class BinaryNumberObserver extends NumberObserver {

	public BinaryNumberObserver(DecimalNumber decimalNumber) {
		this.decimalNumber = decimalNumber;
		this.decimalNumber.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary: "
				+ Integer.toBinaryString(decimalNumber.getNumber()));
	}
}