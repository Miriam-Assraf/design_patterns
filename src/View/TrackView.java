package View;

import Model.Containerr;
import Model.Track;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class TrackView<Container> {

	private Color color1;
	private double x, y, width, heigth, carNumber;
	private int wheelRadius;
	private Containerr container;

	public TrackView(Track track) {
		setX(track.getX());
		setY(track.getY());
		setWidth(track.getWidth());
		setHeigth(track.getHeigth());
		setCarNumber(track.getCarNumber());
		setWheelRadius(track.getWheelRadius());
		setColor(track.getColor());
		setContainer(track.getContainer());
	}

	public Containerr getContainer() {
		return container;
	}

	public void setContainer(Containerr container) {
		this.container = container;
	}

	public Color getColor() {
		return color1;
	}

	public void setColor(Color color) {
		this.color1 = color;
	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public double getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public double getWheelRadius() {
		return wheelRadius;
	}

	public void setWheelRadius(int wheelRadius) {
		this.wheelRadius = wheelRadius;
	}

	public void show(Group root) {
		Rectangle window = new Rectangle(x + (0.02 * x), y + (y * 0.025), (width * 0.2) * 0.6, heigth * 0.2);
		window.setFill(Color.WHITE);
		window.setStroke(Color.BLACK);

		Rectangle cabin = new Rectangle(x, y, width * 0.2, heigth);
		cabin.setFill(color1);

		Rectangle trailer = new Rectangle(x + width * 0.2, y + heigth - (heigth * 0.2), width - (width * 0.2),
				heigth * 0.15);
		trailer.setFill(color1);

		Circle leftWheel = new Circle(x + width * 0.1, y + (heigth * 0.35) + heigth * 0.65 + wheelRadius,
				wheelRadius + (heigth * 0.075));
		Circle midelWheel = new Circle(x + width * 0.35 + wheelRadius,
				y + (heigth * 0.35) + heigth * 0.65 + wheelRadius, wheelRadius + (heigth * 0.075));
		Circle rigthWheel = new Circle(x + width - wheelRadius, y + (heigth * 0.35) + heigth * 0.65 + wheelRadius,
				wheelRadius + (heigth * 0.075));
		Circle miniLeftWheel = new Circle(x + width * 0.1, y + (heigth * 0.35) + heigth * 0.65 + wheelRadius,
				wheelRadius * 0.3);
		miniLeftWheel.setFill(Color.WHITE);
		Circle miniMidelWheel = new Circle(x + width * 0.35 + wheelRadius,
				y + (heigth * 0.35) + heigth * 0.65 + wheelRadius, wheelRadius * 0.3);
		miniMidelWheel.setFill(Color.WHITE);
		Circle miniRigthWheel = new Circle(x + width - wheelRadius, y + (heigth * 0.35) + heigth * 0.65 + wheelRadius,
				wheelRadius * 0.3);
		miniRigthWheel.setFill(Color.WHITE);

		if (container != null) {
			ContainerView temp = new ContainerView(container);
			temp.Show(root);
		}
		root.getChildren().addAll(cabin, window, trailer, leftWheel, midelWheel, rigthWheel, miniMidelWheel,
				miniLeftWheel, miniRigthWheel);
	}
}