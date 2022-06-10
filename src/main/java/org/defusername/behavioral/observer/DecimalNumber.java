package org.defusername.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class DecimalNumber {

	private int number;
	private final List<NumberObserver> numberObserverList = new ArrayList<>();

	public void setNumber(int number) {
		this.number = number;
		notifyAllObservers();
	}

	public int getNumber() {
		return number;
	}

	public void attach(NumberObserver observer) {
		numberObserverList.add(observer);
	}

	public void notifyAllObservers() {
		for (final NumberObserver numberObserver : numberObserverList)
			numberObserver.update();
	}
}