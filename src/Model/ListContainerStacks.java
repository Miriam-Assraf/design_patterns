package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ListContainerStacks implements IContainer {
	protected ArrayList<ContainersStack> containers;
	
	public ListContainerStacks(int numStacks, int stackCapacity, boolean fill) {
		containers = new ArrayList<ContainersStack>();
		
		if (fill) {
			this.fill(numStacks, stackCapacity);
		}
	}
	
	public ListContainerStacks() {
		containers = new ArrayList<ContainersStack>();
	}
	
	public void fill(int numStacks, int stackCapacity) {
		for (int i=0; i<numStacks; i++) {
			containers.add(new ContainersStack(stackCapacity, true));
		}
	}
	
	@Override
	public boolean load(Container container) {
		boolean success = false;
		
		for (ContainersStack stack: this.containers) {
			success = stack.load(container);
			if (success) {
				break;
			}
		}
		
		return success;
	}

	@Override
	public Container unload() {
		ContainersStack stack = this.getMarked();
		
		if (stack != null) {
			return stack.unload();
		}
		return null;
	}
	
	public ContainersStack getMarked() {
		for (ContainersStack stack: this.containers) {
			if (stack.getState() == StackState.MARKED) {
				return stack;
			}
		}
		
		return null;
	}
	
	public int getNumStacks() {
		return this.containers.size();
	}
	
	@Override
	public int getNumContainers() {
		int numContainers = 0;
		
		for (ContainersStack stack: containers) {
			numContainers += stack.getNumContainers();
		}
		return numContainers;
	}
	
	public void markContainer(int numStack, int numContainer) {
		if (numStack > 0 && numStack <= this.containers.size()) {
			ContainersStack stack = this.containers.get(numStack-1);
			boolean success = stack.markContainer(numContainer);
			
			// if container marked
			if (success) {
				// check if exists marked stack
				ContainersStack markedStack = this.getMarked();
				if (markedStack != null) {
					// if does - unmark it
					markedStack.setState(StackState.UNMARKED);
				}
				// mark the given stack
				stack.setState(StackState.MARKED);
			}
		}
	}
	
	/* ------------------------------------Memento-------------------------------------- */
	@Override
	public void undo() {
		for (ContainersStack stack: this.containers) {
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
		for (ContainersStack stack: this.containers) {
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
		return this.containers.iterator();
	}
}