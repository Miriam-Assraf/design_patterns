package View;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class ShapeView {
	protected Color color;
	protected Shape shape;
	
	public ShapeView(Color color) {
		this.color = color;
	}
	/*
	public ShapeView() {
		this.shape.setFill(RandomColor());
	}
*/
	public Shape getShape() {
		return this.shape;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public static Color RandomColor() {
		Random random = new Random();
		return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
