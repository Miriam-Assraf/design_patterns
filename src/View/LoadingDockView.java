package View;

import java.util.Stack;
import Model.Containerr;
import Model.LoadingDock;
import Model.Shape;
import javafx.beans.binding.SetExpression;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class LoadingDockView {

	private int x, y, width;
	private int currentContainers;
	private Stack<Containerr> containers;

	public LoadingDockView(LoadingDock load) {
		setX(load.getX());
		setY(load.getY());
		setWidth(load.getWidth());
		setContainers(load.getContainersStack());
		currentContainers = containers.size();
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Stack<Containerr> getContainers() {
		return containers;
	}

	public void setContainers(Stack<Containerr> container) {
		this.containers = container;
	}

	public void show(Group root) {
		double temp1 = x;
		double temp2 = y;
		double temp3 = width;
		Line line = new Line(x, y, x + width, y);
		root.getChildren().add(line);
		for (int i = 0; i < currentContainers; i++) {
			ContainerView containerView = new ContainerView(containers.get((i)));
			containerView.Show(root);
		}
	}
}
