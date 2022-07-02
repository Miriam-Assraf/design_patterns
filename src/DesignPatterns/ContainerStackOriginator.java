package DesignPatterns;

import Model.ContainersStack;

public class ContainerStackOriginator {
	private ContainersStack stack;

	public ContainerStackMemento saveToMemento(ContainersStack stack) {
		return new ContainerStackMemento(stack);
	}
	
   public ContainersStack getStateFromMemento(ContainerStackMemento memento) {
      return memento.getStack();
   }
}