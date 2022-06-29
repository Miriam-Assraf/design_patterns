package View;

import Model.Ship;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Pair;

public class ShipView {
	public static final double x1 = MainView.width/4;
	
	public static final double y1 = MainView.height-(SeaPortView.portStartY/2);
	public static final double y2 = SeaPortView.portStartY;
	
	public static final int alpha = 20;
	
	private double x2;
	
	private Ship ship;
	
	public ShipView(Ship ship) {
		this.ship = ship;
		this.x2 = x1 + this.ship.getLoadingDock().getNumStacks() * ContainerView.width;
	}

	public void show(Group root) {
		
		
		RectangleView rectangleView = new RectangleView(x1, y1, this.x2-x1, y2-y1);
		TriangleView leftTriangleView = new TriangleView(new Pair<Double, Double>(x1, y1),
				new Pair<Double, Double>(x1, y2), new Pair<Double, Double>(x1 - (this.x2-x1) / 5, y1));
		TriangleView rightTriangleView = new TriangleView(new Pair<Double, Double>(this.x2, y1),
				new Pair<Double, Double>(this.x2, y2), new Pair<Double, Double>(this.x2 / 7, y1));

		root.getChildren().addAll(rectangleView.getShape(), leftTriangleView.getShape(), rightTriangleView.getShape());
		
		//AllStacksView stacksView = new AllStacksView(ship.getLoadingDock(), x1+alpha/2, y1);
		//stacksView.show(root);
	}
	
	public double getX2() {
		return this.x2;
	}
}
