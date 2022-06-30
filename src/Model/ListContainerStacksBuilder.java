package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListContainerStacksBuilder implements IContainer {
	protected ListContainerStacks listStacks;
	private int maxStackSize;
	
	public ListContainerStacksBuilder(int maxStackSize) {
		this.listStacks = new ListContainerStacks();
		this.maxStackSize = maxStackSize;
	}
	
	public void addStack() {
		this.listStacks.containers.add(new ContainersStack(this.maxStackSize, false));
	}
	
	@Override
	public boolean load(Container container) {
		boolean success = this.listStacks.load(container);
		if (!success) {
			this.addStack();
			this.listStacks.load(container);
		}
		return true;
	}

	@Override
	public Iterator<ContainersStack> iterator() {
		return this.listStacks.iterator();
	}

	@Override
	public Container unload() {
		return this.listStacks.unload();
	}

	@Override
	public int getNumContainers() {
		return this.listStacks.getNumContainers();
	}

	@Override
	public void undo() {
		this.listStacks.undo();
		
	}

	@Override
	public void redo() {
		this.listStacks.redo();
		
	}
	
	public int getNumStacks() {
		return this.listStacks.containers.size();
	}
}
