package View;

import java.util.ArrayList;
import java.util.Stack;

import Model.Containerr;
import Model.Ship;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;

public class ShipView {
	private Color color;
	private int x, y, width, heigth, capcity;
	private ArrayList<Stack<Containerr>> containers;

	public ShipView(Ship ship) {
		setX(ship.getX());
		setY(ship.getY());
		setWidth(ship.getWidth());
		setHeigth(ship.getHeight());
		setCapcity(ship.getCapcity());
		setColor(ship.getColor());
		setContainers(ship.getContainers());
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public int getCapcity() {
		return capcity;
	}

	public void setCapcity(int capcity) {
		this.capcity = capcity;
	}

	public ArrayList<Stack<Containerr>> getContainers() {
		return containers;
	}

	public void setContainers(ArrayList<Stack<Containerr>> containers) {
		this.containers = containers;
	}

	public void show(Group root) {
		Rectangle rectangle = new Rectangle(x, y, width, heigth);
		rectangle.setFill(color);

		Polygon trianglePolygon = new Polygon();
		trianglePolygon.getPoints().setAll((double) x, (double) y, (double) x, (double) y + (double) heigth,
				(double) x - (double) width / 5, (double) y);
		trianglePolygon.setFill(color);

		Polygon trianglePolygon1 = new Polygon();
		trianglePolygon1.getPoints().setAll((double) x + width, (double) y, (double) x + width,
				(double) y + (double) heigth, (double) x + width + (double) width / 7, (double) y);
		trianglePolygon1.setFill(color);

		root.getChildren().addAll(rectangle, trianglePolygon, trianglePolygon1);

		for (int i = 0; i < containers.size(); i++) {
			for (int j = 0; j < containers.get(i).size(); j++) {
				ContainerView temp = new ContainerView(containers.get(i).get(j));
				temp.Show(root);
			}
		}
	}
}
