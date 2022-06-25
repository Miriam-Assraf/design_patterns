package Model;

import java.util.Stack;

public class LoadingDock {
	private static final int width = 150;
	ContainersStack containers;
	
	public LoadingDock(int capacity) {
		containers = new ContainersStack(capacity);
	}

	public static int getWidth() {
		return width;
	}

	public void addContainer(Container container) {
		this.containers.load(container);
	}
	
	public Container removeContainer() {
		return this.containers.unload();
	}
}
