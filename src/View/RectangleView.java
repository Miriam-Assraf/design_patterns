package View;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleView extends ShapeView {
	
	public RectangleView(double x, double y, double width, double heigth, Color color) {
		super(color);
		this.shape = new Rectangle(x, y, width, heigth);	
		this.shape.setFill(color);
	}
	
	public RectangleView(double x, double y, double width, double heigth) {
		this(x, y, width, heigth, ShapeView.RandomColor());
	}
}
