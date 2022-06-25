package Model;

import javafx.scene.paint.Color;

public class Square extends Shape{
	protected int area;

	public Square(int size) {
		super(size, size);
	}

	public Square(int size, Color color) {
		super(size, size, color);
	}
}
