package View;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Pair;

public class LineView extends ShapeView {
	public LineView(Pair<Double, Double> p1, Pair<Double, Double> p2) {
		super(Color.BLACK);
		this.shape = new Line(p1.getKey(), p1.getValue(), p2.getKey(), p2.getValue());
	}
}
