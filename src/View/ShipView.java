package View;

import Model.Ship;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Pair;

public class ShipView {
	public static final double x = MainView.width/5;
	public static final double y = SeaPortView.portStartY - (MainView.height-SeaPortView.portStartY)/2; // y-h
	public static final double height = (MainView.height-SeaPortView.portStartY)/2;
	
	public static final int alpha = 20;
	private double width;
	
	private Ship ship;
	
	public ShipView(Ship ship) {
		this.ship = ship;
	}

	public void show(Group root) {		
		LoadingDockView loadingDockView = new LoadingDockView(this.ship.getLoadingDock(), x, y);
		loadingDockView.show(root);
		
		this.width = loadingDockView.getWidth();
		
		RectangleView rectangleView = new RectangleView(x, y, this.width, height);
		TriangleView leftTriangleView = new TriangleView(new Pair<Double, Double>(x, y),
				new Pair<Double, Double>(x, y + height), new Pair<Double, Double>(x - this.width / 5, y), rectangleView.getColor());
		TriangleView rightTriangleView = new TriangleView(new Pair<Double, Double>(x + this.width, y),
				new Pair<Double, Double>(x + this.width, y + height), new Pair<Double, Double>(x + this.width + this.width / 7, y), rectangleView.getColor());

		root.getChildren().addAll(rectangleView.getShape(), leftTriangleView.getShape(), rightTriangleView.getShape());
	}
	
	public double getX2() {
		return this.width;
	}
}
