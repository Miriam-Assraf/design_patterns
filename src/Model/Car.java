package Model;

import javafx.scene.paint.Color;

public class Car extends Square {

	protected static final int wheelRadius = 7;
	protected int carNumber;

	public Car() {
		super();
	}

	public Car(int x, int y, int width, int heigth, int carNumber) {
		this(x, y, RandomColor(), width, heigth, carNumber);
	}

	public Car(int x, int y, Color color, int width, int heigth, int carNumber) {
		super(x, y, color, width, heigth);
		setCarNumber(carNumber);
	}

	public int getCarNumber() {
		return carNumber;
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
