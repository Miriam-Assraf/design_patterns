package Model;

import javafx.scene.paint.Color;

public class Track<T extends Containerr > extends Car implements Movetable {
	Containerr container;

	public Track() {
		super();
	}

	public Track(int x, int y, int width, int heigth, int carNumber) {
		this(x, y, RandomColor(), width, heigth, carNumber);
	}

	public Track(int x, int y, Color color, int width, int heigth, int carNumber ) {
		super(x, y, color, width, heigth, carNumber);
		this.container = container;
	}

	public Containerr getContainer() {
		return container;
	}

	public boolean addContainer(Containerr container) {
		if (container != null) {
			container.setX(x+container.getWidth()/2);
			container.setY(y+container.getHeigth()-13);
			this.container = container;
			return true;
		}
		return false;
	}
	
	public Containerr removeContainer() {
		return container;
	}
}
