package View;

import Model.Ship;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Pair;

public class ShipView {
	public static final Color color = Color.LIGHTSLATEGREY;
	public static final double x = MainView.width/5;
	public static final double y = SeaPortView.portStartY - (MainView.height-SeaPortView.portStartY)/1.5; // y-h
	public static final double height = (MainView.height-SeaPortView.portStartY)/1.5;
	
	public static final int alpha = 20;
	//private double width;
	
	//private LoadingDockView loadingDockView;
	private RectangleView rectangleView;
	private TriangleView leftTriangleView;
	private TriangleView rightTriangleView;
	
	public ShipView(double width) {
		//this.loadingDockView = new LoadingDockView(ship.getLoadingDock(), x, y);
		//this.width = width; //loadingDockView.getWidth();
		
		this.rectangleView = new RectangleView(x, y, width, height, color);
		this.leftTriangleView = new TriangleView(new Pair<Double, Double>(x, y),
				new Pair<Double, Double>(x, y + height), new Pair<Double, Double>(x - width / 5, y), color);
		this.rightTriangleView = new TriangleView(new Pair<Double, Double>(x + width, y),
				new Pair<Double, Double>(x + width, y + height), new Pair<Double, Double>(x + width + width / 7, y), color);

	}
	
	public void show(Group root) {		
		//this.loadingDockView.show(root);
		root.getChildren().addAll(rectangleView.getShape(), leftTriangleView.getShape(), rightTriangleView.getShape());
	}
	
	//public double getWidth() {
		//return this.width;
	//}
}
