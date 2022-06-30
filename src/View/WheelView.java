package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class WheelView {
	private double x,y, radius;
	
	public WheelView(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void show(Group root) {
		CircleView tireView = new CircleView(this.x, this.y, this.radius, Color.BLACK);
		CircleView wheelView = new CircleView(this.x, this.y, this.radius/3, Color.SILVER);
		
		root.getChildren().addAll(tireView.getShape(), wheelView.getShape());

	}
}
