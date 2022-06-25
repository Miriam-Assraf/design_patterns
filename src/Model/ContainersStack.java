package Model;

import java.util.Stack;

public class ContainersStack implements IContainersStack {
	Stack<Container> containers;
	int capacity;
	
	public ContainersStack(int capacity) {
		this.capacity = capacity;
		this.containers = new Stack<Container>();
	}
	
	@Override
	public boolean load(Container container) {
		boolean success = false;
		if (this.containers.size() < this.capacity) {
			this.containers.push(container);
			success = true;
		}
		
		return success;
	}

	@Override
	public Container unload() {
		if (this.containers.size() > 0)
			return this.containers.pop();
		else
			return null;
	}
	
	public Stack<Container> getContainers() {
		return this.containers;
	}
	
}