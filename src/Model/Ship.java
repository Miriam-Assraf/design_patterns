package Model;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.paint.Color;

public class Ship<T extends Containerr<Object>> extends Shape implements ShipMovetable {
	public static final int MaxHeigth = 5;
	private static int idSerial = 0;
	private int width, height, id, capcity, currentCapCity = 0;
	private ArrayList<Stack<Containerr>> containers;

	public Ship() {
		super();
		setId(idSerial++);
		containers = new ArrayList<Stack<Containerr>>();
	}

	public Ship(int x, int y, int width, int height, int capcity) {
		this(x, y, RandomColor(), width, height, capcity);
	}

	public Ship(int x, int y, Color color, int width, int height, int capcity) {
		super(x, y, color);
		setId(idSerial++);
		setWidth(width);
		setHeight(height);
		setCapcity(capcity);
		containers = new ArrayList<Stack<Containerr>>();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapcity() {
		return capcity;
	}

	public void setCapcity(int capcity) {
		this.capcity = capcity;
	}

	public static int getMaxheigth() {
		return MaxHeigth;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Ship)) {
			return false;
		}
		Ship<T> temp = (Ship<T>) obj;
		return id == temp.getId();
	}

	public ArrayList<Stack<Containerr>> getContainers() {
		return containers;
	}

	public void addContainer(Containerr c) {
		int minStackIndex = 5;
		for (int i = 0; i < containers.size(); i++) {
			if (containers.get(i).size() < minStackIndex) {
				minStackIndex = i;
			}
		}
		addContainerToStack(c, minStackIndex);
	}

	public Containerr removeContainer() {

		for (int i = 0; i < containers.size(); i++) {

			for (int j = 0; j < containers.get(i).size(); j++) {

				if (containers.get(i).get(j).isMark()) {

					return containers.get(i).pop();
				}
			}
		}
		return null;
	}

	public Containerr getContainerByCoords(int xx, int yy) {

		// here we checking with The (x,y) in range of containers
		int[] range = getRangeToClick();
		if (x <= range[0] || x >= range[1] || y >= range[2] || y <= range[3]) {
			return null;
		}

		// here we calculate where the container stay and take out the top container
		int foundContainerX = (((xx - x) / containers.get(0).get(0).getWidth()) + 1) - 1;
		int foundContainerY = (((yy - y) / containers.get(0).get(0).getHeigth()) + 1) - 1;
		return containers.get(foundContainerX).pop();
	}

	public boolean markContainerByCoords(int x1, int y1, boolean mark) {
		// here we checking with The (x,y) in range of containers
		int[] range = getRangeToClick();
		if (x1 <= range[0] || x1 >= range[1] || y1 >= range[2] || y1 <= range[3]) {
			return false;
		}

		// here we calculate where the container stay and take out the top container
		int foundContainerX = (((x1 - x) / containers.get(0).get(0).getWidth()) + 1);
		int foundContainerY = (((y - y1) / containers.get(0).get(0).getHeigth()) + 1);
		containers.get(foundContainerX - 1).get(foundContainerY - 1).setMark(mark);
		return true;
	}

	public int[] getMarkedContainerLocation() {
		int[] location = new int[2];
		for (int i = 0; i < containers.size(); i++) {
			for (int j = 0; j < containers.get(i).size(); j++) {
				if (containers.get(i).get(j).isMark()) {
					location[0] = i; // number stack
					location[1] = j; // index in stack
					return location;
				}
			}
		}
		return location;
	}

	public boolean addContainerToStack(Containerr container, int stackNumber) {
		if (containers.size() < stackNumber + 1) {
			return false;
		}
		if (containers.get(stackNumber).size() < MaxHeigth) {
			container.setX(x + stackNumber * (container.getWidth() + 5));
			container.setY(y - (containers.get(stackNumber).size() + 1) * container.getHeigth());
			containers.get(stackNumber).push(container);
			return true;
		}
		return false;
	}

	public Containerr removeContainerFromStack(int stackNumber) {
		return containers.get(stackNumber).pop();
	}

	public void addContainers(Containerr container) {

		// here we checking if we have more place in the stack
		// if not we create a new stock
		// and adding container to last stock
		if (currentCapCity++ % MaxHeigth == 0) {
			containers.add(new Stack<Containerr>());
		}

		container.setX(x + (containers.size() - 1) * (container.getWidth() + 5));
		container.setY(y - (containers.get(containers.size() - 1).size() + 1) * container.getHeigth());
		containers.get(containers.size() - 1).push(container);
	}

	private int[] getRangeToClick() {
		int[] range = new int[4];
		int SrangeX = x;
		int SrangeY = y;
		int ErangeX = x + containers.size() * containers.get(0).get(0).getWidth();
		int ErangeY = y - (containers.get(0).get(0).getHeigth()) * MaxHeigth;
		range[0] = SrangeX;
		range[1] = ErangeX;
		range[2] = SrangeY;
		range[3] = ErangeY;
		return range;

	}
}
