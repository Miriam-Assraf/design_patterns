package Model;

import javafx.scene.paint.Color;

public class Car extends Square {

	protected static final int wheelRadius = 7;
	protected int carNumber;

	public Car(int size) {
		super(size);
	}

	public Car(int size, Color color) {
		super(size, color);
	}

	public int getCarNumber() {
		return this.carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getWheelRadius() {
		return wheelRadius;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Car)) {
			return false;
		}
		Car temp = (Car) obj;
		return carNumber == temp.getCarNumber();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
