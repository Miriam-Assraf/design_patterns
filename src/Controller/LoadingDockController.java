package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import DesignPatterns.ContainerObservable;
import DesignPatterns.ContainerObserver;
import DesignPatterns.Observable;
import DesignPatterns.UserInputObserver;
import Enums.ContainerState;
import Model.Container;
import Model.ContainersStack;
import Model.LoadingDock;
import View.ContainerView;
import View.LoadingDockView;
import javafx.scene.Group;

public class LoadingDockController implements ContainerObservable<ContainerObserver>, UserInputObserver {
	
	private LoadingDockView loadingDockView;
	private LoadingDock loadingDock;
	private InputManager inputManager;
	
	// map between stack id and container id to container view
	ArrayList<ContainerObserver> observers = new ArrayList<ContainerObserver>();
	private Map<Integer, Map<Integer, ContainerView>> stacks;
	private double x,y,width;
	public LoadingDockController(InputManager inputManager, LoadingDock loadingDock, double x, double y, double width) {
		inputManager.attach(this);
		this.inputManager = inputManager;
		this.loadingDock = loadingDock;
		this.initializeDock(x, y, width);
		this.x = x;
		this.y=y;
		this.width=width;
	}
	
	private void initializeDock(double x, double y, double width) {
		this.stacks = new HashMap<Integer, Map<Integer, ContainerView>>();
		this.loadingDockView = new LoadingDockView(x, y, width);
		
		int currStack = 0;
		for (ContainersStack stack: this.loadingDock.getContainerStacks()) {
			double stackX = x + currStack*(ContainerView.width + LoadingDockView.alpha);
			double stackY = y - ContainerView.height;
			Map<Integer, ContainerView> containers = new HashMap<Integer, ContainerView>();
			
			int currContainer = 0;
			for (Container container: stack.getContainers()) {
				boolean marked = false;
				if (container.getState() == ContainerState.MARKED) {
					marked = true;
				}
				ContainerView containerView = new ContainerView(stackX, stackY - currContainer*ContainerView.height, marked);
				containers.put(container.getId(), containerView);
				currContainer++;
			}
			currStack++;
			
			this.stacks.put(stack.getId(), containers);
		}
	}
		
	public LoadingDockView getLoadingDockView() {
		return this.loadingDockView;
	}
	
	public ContainerView getContainerView(int numStack, int numContainer) {
		return this.stacks.get(numStack).get(numContainer);
	}

	@Override
	public void attach(ContainerObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void detach(ContainerObserver observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers(int stackId, int containerId) {
		for (ContainerObserver observer: observers) {
			observer.handle(stackId, containerId);
		}
	}
	
	public void updateView(Group root) {
		initializeDock(x,y,width);
		this.loadingDockView.show(root);
		for (int stackId: this.stacks.keySet()) {
			for (int containerId: this.stacks.get(stackId).keySet()) {
				ContainerView containerView = this.stacks.get(stackId).get(containerId);
				containerView.show(root);
			}
		}
	}

	@Override
	public void handle() {
		boolean found = false;
		
		for (int stackId: this.stacks.keySet()) {
			for (int containerId: this.stacks.get(stackId).keySet()) {
				ContainerView containerView = this.stacks.get(stackId).get(containerId);
				double x1 = containerView.getX();
				double x2 = containerView.getX()+containerView.width;
				double y1 = containerView.getY();
				double y2 = containerView.getY()+containerView.height;
				
				if (this.inputManager.check(x1,x2,y1,y2)) {
					notifyObservers(stackId, containerId);
					found = true;
					break;
				}
				
			}
			if (found) {
				break;
			}
		}
	}
}
