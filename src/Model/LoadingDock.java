package Model;

public class LoadingDock {
	//public static final int MaxContainers = 5;
	private IContainer containers;
	
	public LoadingDock(int numStacks, int stackCapacity) {
		if (numStacks == 1) {
			this.containers = new ContainersStack(stackCapacity);
		}
		else {
			this.containers = new ListContainerStacks(numStacks, stackCapacity);
		}
	}
	
	public LoadingDock(int numStacks) {
		if (numStacks == 1) {
			containers = new ContainersStack();
		}
		else {
			this.containers = new ListContainerStacks();
		}
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
		if (this.containers instanceof ListContainerStacks) {
			return ((ListContainerStacks) this.containers).getNumStacks();
		}
		
		return 1;
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
