package Controller;

import Model.LoadingDock;
import Model.Truck;
import View.ContainerView;
import View.LoadingDockView;
import View.TruckView;
import javafx.scene.Group;

public class TruckController {
	private TruckView truckView;
	private LoadingDockController loadingDockController;
	
	public TruckController(InputManager inputManager, Truck truck) {
		if (truck != null) {
			LoadingDock loadingDock = truck.getLoadingDock();
			double width = loadingDock.getNumStacks() * ContainerView.width + (loadingDock.getNumStacks() - 1) * LoadingDockView.alpha;
			this.truckView = new TruckView(width);
						
			this.loadingDockController = new LoadingDockController(inputManager, loadingDock, TruckView.x + TruckView.width + TruckView.alpha, TruckView.y + TruckView.height - TruckView.height/4, width);
		}
		else {
			this.truckView = null;
			this.loadingDockController = null;
		}
	}
	
	public void updateView(Group root) {
		truckView.show(root);
		this.loadingDockController.updateView(root);
	}
	
	public LoadingDockController getLoadingDockController() {
		return this.loadingDockController;
	}
}