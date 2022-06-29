package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleView extends ShapeView {
	
	public CircleView(double x_center, double y_center, double radius, Color color) {
		this.shape = new Circle(x_center, y_center, radius);
		this.shape.setFill(color);
	}
	
	public CircleView(double x_center, double y_center, double radius) {
		this(x_center, y_center, radius, ShapeView.RandomColor());
	}
}