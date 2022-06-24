package View;

import Model.Containerr;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ContainerView {
	private int x, y, width, heigth;
	private Color color;
	private boolean mark;

	public ContainerView(Containerr<Object> container) {
		setX(container.getX());
		setY(container.getY());
		setWidth(container.getWidth());
		setHeigth(container.getHeigth());
		setColor(container.getColor());
		setMark(container.isMark());
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void Show(Group root) {
		Rectangle rectangle = new Rectangle(x, y, width, heigth);
		rectangle.setFill(color);
		root.getChildren().add(rectangle);
		if (mark) {
			Line line0 = new Line(x, y, x + width, y);
			line0.setStrokeWidth(3);
			line0.setStroke(Color.RED);
			Line line1 = new Line(x, y + heigth, x + width, y + heigth);
			line1.setStrokeWidth(3);
			line1.setStroke(Color.RED);
			Line line2 = new Line(x, y, x, y + heigth);
			line2.setStrokeWidth(3);
			line2.setStroke(Color.RED);
			Line line3 = new Line(x + width, y, x + width, y + heigth);
			line3.setStrokeWidth(3);
			line3.setStroke(Color.RED);
			root.getChildren().addAll(line0, line1, line2, line3);
		}

		double spaceLine = width * 0.1;
		double num0fLine = width / spaceLine;
	}
}
