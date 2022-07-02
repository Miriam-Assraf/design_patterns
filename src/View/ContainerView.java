package View;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class ContainerView {	
	public static final Color unmarkedColor = Color.SILVER;
	public static final Color markedColor = Color.DARKGREY;
	public static final Color strokeColor = Color.DARKGREY;
	
	public static final double width = MainView.width/10;
	public static final double height = (MainView.height-SeaPortView.portStartY)/6;
	private RectangleView containerView;
	private double x, y;
	
	public ContainerView(double x, double y, boolean marked) {
		Color color = unmarkedColor;
		if (marked) {
			color = markedColor;
		}
		this.containerView = new RectangleView(x, y, width, height, color);
		this.containerView.getShape().setStroke(strokeColor);
		this.x = x;
		this.y = y;
	}
	
	public void show(Group root) { 
		root.getChildren().add(containerView.getShape());
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
}
