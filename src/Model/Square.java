package Model;

import javafx.scene.paint.Color;

public class Square extends Shape {
	protected int width, heigth;
	protected int area;

	public Square() {
		super();
	}

	public Square(int x, int y, int width, int heigth) {
		this(x, y, RandomColor(), width, heigth);
	}

	public Square(int x, int y, Color color, int width, int heigth) {
		super(x, y, color);
		setWidth(width);
		setHeigth(heigth);
		setArea(width, heigth);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getArea() {
		return area;
	}

	private void setArea(int width, int height) {
		this.area = width * height;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	@Override
	public String toString() {
		return super.toString() + "The width is: " + width + "\n The heigth is: " + heigth + "\n The area is: " + area
				+ "\n";
	}

	public boolean equals(Object obj) {
		return false;
	}
}
