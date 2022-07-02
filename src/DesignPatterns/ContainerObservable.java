package DesignPatterns;

public interface ContainerObservable<T> extends Observable<T> {
	public void notifyObservers(int stackId, int containerId);
}
