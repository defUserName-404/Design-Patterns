package org.defusername.behavioral.observer;

public class OctalNumberObserver extends NumberObserver {

	public OctalNumberObserver(DecimalNumber decimalNumber) {
		this.decimalNumber = decimalNumber;
		this.decimalNumber.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal: "
				+ Integer.toOctalString(decimalNumber.getNumber()));
	}
}