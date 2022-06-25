package Model;

import java.util.ArrayList;
import java.util.Stack;

public class ListContainersStack implements IContainersStack {
	private ArrayList<ContainersStack> containers;
	private int numStacks, stackCapacity;
	
	public ListContainersStack(int numStacks, int stackCapacity) {
		containers = new ArrayList<ContainersStack>(numStacks);
		this.numStacks = numStacks;
		this.stackCapacity = stackCapacity;
	}

	@Override
	public boolean load(Container container) {
		boolean success = false;
		
		for (int i=0; i<this.numStacks; i++) {
			success = containers.get(i).load(container);
			if (success) {
				break;
			}
		}
		
		return success;
	}

	@Override
	public Container unload() {
		Container container = null;
		
		for (ContainersStack stack: containers) {
			int containerNum = -1;
			
			for (int i=0; i<stack.containers.size(); i++) {
				if (stack.containers.get(i).getState() == StateE.MARKED) {
					containerNum = i;
					break;
				}
			}
			
			if (containerNum != -1)	{
				// found in stack
				for (int i=0; i<containerNum; i++) {
					container = stack.unload();
				}
				break;
			}
		}
		
		return container;
	}

}