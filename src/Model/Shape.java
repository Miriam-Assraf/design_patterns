package Model;

import java.util.Random;
import javafx.scene.paint.Color;

public class Shape {
	protected int x, y;
	protected Color color;

	public Shape() {
		this(0, 0, RandomColor());
	}

	public Shape(int x, int y) {
		this(x, y, RandomColor());
	}

	public Shape(int x, int y, Color color) {
		setX(x);
		setY(y);
		setColor(color);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "The X located is: " + x + "\n The Y located is: " + y + " \n The color is: " + color.toString() + "\n";
	}

	public static Color RandomColor() {
		Random random = new Random();
		return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
