package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Pair;

public class TriangleView extends ShapeView {
	
	public TriangleView(Pair<Double, Double> p1, Pair<Double, Double> p2, Pair<Double, Double> p3, Color color) {
		this.shape = new Polygon();
		((Polygon) this.shape).getPoints().setAll(p1.getKey(), p1.getValue(), 
				p2.getKey(), p2.getValue(), p3.getKey(), p3.getValue());
		this.shape.setFill(color);
	}
	
	public TriangleView(Pair<Double, Double> p1, Pair<Double, Double> p2, Pair<Double, Double> p3) {
		this(p1, p2, p3, ShapeView.RandomColor());
	}
}
