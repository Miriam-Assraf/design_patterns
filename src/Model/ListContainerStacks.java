package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import DesignPatterns.IContainer;
import Enums.ContainerState;

public class ListContainerStacks implements IContainer {
	private ArrayList<ContainersStack> containers;
	
	public ListContainerStacks(int numStacks, int stackCapacity, boolean fill) {
		setContainers(new ArrayList<ContainersStack>());
		
		if (fill) {
			this.fill(numStacks, stackCapacity);
		}
	}
	
	public ListContainerStacks() {
		setContainers(new ArrayList<ContainersStack>());
	}
	
	public void fill(int numStacks, int stackCapacity) {
		for (int i=0; i<numStacks; i++) {
			getContainers().add(new ContainersStack(stackCapacity, true));
		}
	}
	
	@Override
	public boolean load(Container container) {
		boolean success = false;
		
		for (ContainersStack stack: this.getContainers()) {
			success = stack.load(container);
			if (success) {
				break;
			}
		}
		
		return success;
	}
	
	protected boolean hasMarkedContainer(ContainersStack stack) {
		for (Container container: stack.getContainers()) {
			if (container.getState() == ContainerState.MARKED) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Container unload() {
		for (ContainersStack stack: this.getContainers()) {
			if (hasMarkedContainer(stack)) {
				return stack.unload();
			}
		}
		
		return null;
	}
	
	public int getNumStacks() {
		return this.getContainers().size();
	}
	
	@Override
	public int getNumContainers() {
		int numContainers = 0;
		
		for (ContainersStack stack: getContainers()) {
			numContainers += stack.getNumContainers();
		}
		return numContainers;
	}
	
	public ContainersStack getById(int id) {
		for (ContainersStack stack: this.getContainers()) {
			if (stack.getId() == id) {
				return stack;
			}
		}
		
		return null;
	}
	
	public void markContainer(int numStack, int numContainer) {
		ContainersStack stack = this.getById(numStack);
		
		if (stack != null ) {
			boolean success = stack.markContainer(numContainer);
		}
	}
	
	/* ------------------------------------Memento-------------------------------------- */
	@Override
	public void undo() {
		for (ContainersStack stack: this.getContainers()) {
			if (stack.getState() == StackState.MARKED) {
				stack.setState(StackState.UNMARKED);
			}
			if (stack.careTaker.undo().getState() == StackState.MARKED) {
				stack.undo();
			}
		}
	}
	
	@Override
	public void redo() {
		for (ContainersStack stack: this.getContainers()) {
			if (stack.getState() == StackState.MARKED) {
				stack.setState(StackState.UNMARKED);
			}
			if (stack.careTaker.redo().getState() == StackState.MARKED) {
				stack.redo();
			}
		}
	}
	/* --------------------------------------------------------------------------------- */
	
	@Override
	public String toString() {
		return String.valueOf(this.getNumContainers()) + " containers";
	}
	
	@Override
	public Iterator<ContainersStack> iterator() {
		return this.getContainers().iterator();
	}

	public ArrayList<ContainersStack> getContainers() {
		return containers;
	}

	public void setContainers(ArrayList<ContainersStack> containers) {
		this.containers = containers;
	}
}