package org.defusername.behavioral.observer;

public class HexadecimalNumberObserver extends NumberObserver {

	public HexadecimalNumberObserver(DecimalNumber decimalNumber) {
		this.decimalNumber = decimalNumber;
		this.decimalNumber.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hexadecimal: "
				+ Integer.toHexString(decimalNumber.getNumber()));
	}
}
