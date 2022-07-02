package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;
import java.util.function.Consumer;

import DesignPatterns.ContainerStackCareTaker;
import DesignPatterns.IContainer;
import Enums.ContainerState;

/* -------------------------------------State--------------------------------------- */
enum StackState {
	MARKED,
	UNMARKED
}
/* --------------------------------------------------------------------------------- */

public class ContainersStack implements IContainer, Cloneable {
	private static int idSerial = 0;
	private int id;
	private Stack<Container> containers;
	private int capacity;
	private StackState state;
	/* ------------------------------------Memento-------------------------------------- */
	protected ContainerStackCareTaker careTaker = new ContainerStackCareTaker();
	/* --------------------------------------------------------------------------------- */
	
	public ContainersStack(int capacity, boolean fill) {	
		this.id = idSerial++;
		this.containers = new Stack<Container>();
		this.state = StackState.UNMARKED;
		this.capacity = capacity;
		
		if (fill) {
			this.fill(capacity);
		}
	}
	
	public void fill(int capacity) {
		for (int i=0; i<capacity; i++) {
			Container container = new Container<>();
			this.containers.push(container);
			container.setState(ContainerState.LOADED);
		}
	}
	
	public Container getById(int id) {
		for (Container container: this.containers) {
			if (container.getId() == id) {
				return container;
			}
		}
		
		return null;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public boolean load(Container container) {
		boolean success = false;
		if (this.containers.size() < this.capacity && container != null) {
			/* ------------------------------------Memento-------------------------------------- */
			try {
				careTaker.savePrevState((ContainersStack) this.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			/* --------------------------------------------------------------------------------- */
			this.containers.push(container);
			container.setState(ContainerState.LOADED);
			success = true;
		}
		
		return success;
	}
	
	public boolean markContainer(int numContainer) {
		boolean success = false;
		Container container = this.getById(numContainer);
		
		if (container != null) {
			container.setState(ContainerState.MARKED);
			success = true;
		}
		return success;
	}

	@Override
	public Container unload() {
		Container container = null; 
		
		if (this.containers.size() > 0) {
			// save to memento
			try {
				careTaker.savePrevState((ContainersStack) this.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			container = this.containers.pop();
			if (container.getState() == ContainerState.MARKED) {
				this.state = StackState.UNMARKED;
			}
			container.setState(ContainerState.PENDING);
		}
		return container;
	}
	
	/* ------------------------------------Memento-------------------------------------- */
	@Override
	public void undo() {
		try {
			this.copyStack(careTaker.undo(), this);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void redo() {
		try {
			this.copyStack(careTaker.redo(), this);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	/* --------------------------------------------------------------------------------- */
	
	public Stack<Container> getContainers() {
		return this.containers;
	}
	
	
	public void setState(StackState state) {
		this.state = state;
	}
	
	public StackState getState() {
		return this.state;
	}
	
	@Override
	public int getNumContainers() {
		return containers.size();
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getNumContainers()) + " containers";
	}
	
	/* -----------------------------------Prototype------------------------------------- */
	
	public ContainersStack copyStack(ContainersStack originStack, ContainersStack destStack) throws CloneNotSupportedException {
		// implement iterator by capacity or remove prev extra capcity if any
		destStack.state = originStack.state;
		destStack.capacity = originStack.capacity;
		
		for (int i=0; i<originStack.containers.size(); i++) {
			destStack.load((Container) originStack.containers.get(i).clone());
		}
		
		return destStack;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ContainersStack copyStack = new ContainersStack(this.capacity, false);
		return this.copyStack(this, copyStack);
	}
	/* --------------------------------------------------------------------------------- */

	/* -----------------------------------Iterator-------------------------------------- */
	@Override
	public Iterator<ContainersStack> iterator() {
		ArrayList<ContainersStack> singleStack = new ArrayList<ContainersStack>();

		singleStack.add(this);
		return singleStack.iterator();
	}

	@Override
	public void forEach(Consumer<? super ContainersStack> action) {
		action.accept(this);
	}

	@Override
	public Spliterator<ContainersStack> spliterator() {
		return null;
	}
	/* --------------------------------------------------------------------------------- */
}