package Model;

import java.util.Random;
import javafx.scene.paint.Color;

public class Shape {
	protected int width, height;
	protected Color color;

	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
		this.color = RandomColor();		
	}

	public Shape(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setWidth(int width) {
		if (width > 0) {
			this.width = width;
		}
	}
	
	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
		}
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getArea() {
		return this.width*this.height;
	}
	//@Override
	//public boolean equals(Object obj) {
	//	return super.equals(obj);
	//}

	@Override
	public String toString() {
		return "Shape width: " + String.valueOf(this.width) + "\nShape height: " + String.valueOf(this.height) + "\nSahpe color: " + color.toString() + "\n";
	}

	public static Color RandomColor() {
		Random random = new Random();
		return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
