package DesignPatterns;

import java.util.Stack;

import Model.ContainersStack;

public class ContainerStackCareTaker {
	private Stack<ContainerStackMemento> undoStack = new Stack<ContainerStackMemento>();
	private Stack<ContainerStackMemento> redoStack = new Stack<ContainerStackMemento>();
	private ContainerStackOriginator originator = new ContainerStackOriginator();
	
	public void savePrevState(ContainersStack stack) {
		ContainerStackMemento memento = originator.saveToMemento(stack);
		undoStack.push(memento);
	}
	
	public ContainersStack undo() {
		ContainerStackMemento prevState = undoStack.pop();
		// save prevState to redoStack
		redoStack.push(prevState);
		// return prevState stack
		return originator.getStateFromMemento(prevState);
	}
	
	public ContainersStack redo() {
		ContainerStackMemento nextState = redoStack.pop();
		// return nextState stack
		return originator.getStateFromMemento(nextState);
	}
	
}