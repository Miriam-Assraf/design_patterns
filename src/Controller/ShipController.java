package Controller;

import Model.LoadingDock;
import Model.Ship;
import View.ContainerView;
import View.LoadingDockView;
import View.ShipView;
import javafx.scene.Group;

public class ShipController {
	//private Ship ship;
	private ShipView shipView;
	private LoadingDockController loadingDockController;
	
	public ShipController(InputManager inputManager, Ship ship) {
		//this.ship = ship;
		if (ship != null) {
			LoadingDock loadingDock = ship.getLoadingDock();
			double width = loadingDock.getNumStacks() * ContainerView.width + (loadingDock.getNumStacks() - 1) * LoadingDockView.alpha;
			this.shipView = new ShipView(width);
			this.loadingDockController = new LoadingDockController(inputManager, loadingDock, ShipView.x, ShipView.y, width);
		}
		else {
			this.shipView = null;
			this.loadingDockController = null;
		}
	}
	
	public void updateView(Group root) {
		shipView.show(root);
		this.loadingDockController.updateView(root);
	}
	
	public LoadingDockController getLoadingDockController() {
		return this.loadingDockController;
	}
}
