package Model;

public class ContainerStackMemento {
	private ContainersStack stack;
	
	public ContainerStackMemento(ContainersStack stack) {
		this.stack = stack;
	}
	
	public ContainersStack getStack() {
		return this.stack;
	}
}
