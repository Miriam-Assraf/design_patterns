package Model;

import java.util.Stack;

public class LoadingDock<T extends Containerr> implements Movetable {
	private static final int width = 150;
	private int x, y;
	Stack<Containerr> containers;

	public LoadingDock() {
		this(0, 0);
	}
	
	public LoadingDock(int x, int y) {
		setX(x);
		setY(y);
		containers = new Stack<Containerr>();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public static int getWidth() {
		return width;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSizeStack() {
		return containers.size();
	}

	public Containerr getContainer() {
		return containers.pop();
	}

	public boolean addContainer(Containerr container) {
		this.containers.push(container);
		container.setX((x + width / 2 - containers.get(containers.size() - 1).getWidth() / 2));
		container.setY(y - (containers.size()) * containers.get(containers.size() - 1).getHeigth());
		return true;
	}

	public Stack<Containerr> getContainersStack() {
		return containers;
	}

	public Containerr removeContainer() {
		if (containers.size() > 0)
			return containers.pop();
		else
			return null;
	}
}
