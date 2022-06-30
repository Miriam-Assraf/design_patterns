package Model;

public class LoadingDock {
	//public static final int MaxContainers = 5;
	private IContainer containers;
	private int numStacks;
	
	public LoadingDock(int numStacks, int stackCapacity, boolean fill) {
		this.numStacks = numStacks;
		if (numStacks == 1) {
			this.containers = new ContainersStack(stackCapacity, fill);
		}
		else {
			this.containers = new ListContainerStacks(numStacks, stackCapacity, fill);
		}
	}
	
	public LoadingDock(int maxStackSize) {
		this.containers = new ListContainerStacksBuilder(maxStackSize);
	}
	
	public IContainer getContainerStacks() {
		return this.containers;
	}
	
	public boolean addContainer(Container container) {
		return this.containers.load(container);
	}
	
	public Container removeContainer() {
		return this.containers.unload();
	}
	
	public boolean markContainer(int numStack, int numContainer) {
		boolean success = false;
		if (this.containers instanceof ListContainerStacks) {
			((ListContainerStacks) this.containers).markContainer(numStack, numContainer);
			success = true;
		}
		return success;
	}
	
	public int getNumContainers() {
		return this.containers.getNumContainers();
	}
	
	public int getNumStacks() {
		return this.numStacks;
	}
	
	public void undo() {
		this.containers.undo();
	}
	
	public void redo() {
		this.containers.redo();
	}
	
	@Override
	public String toString() {
		return this.containers.toString();
	}
}
