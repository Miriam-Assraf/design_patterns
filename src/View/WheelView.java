package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class WheelView {
	private CircleView tireView;
	private CircleView wheelView;
	
	public WheelView(double x, double y, double radius) {
		this.tireView = new CircleView(x, y, radius, Color.BLACK);
		this.wheelView = new CircleView(x, y, radius/3, Color.SILVER);
	}
	
	public void show(Group root) {
		root.getChildren().addAll(tireView.getShape(), wheelView.getShape());
	}
}
