package View;

import Controller.ShipManager;
import Controller.TruckManager;
import Model.NotNullSeaPort;
import Model.Ship;
import Model.Truck;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class SeaPortView {
	public static final double portStartY = 2*MainView.height/3;
	public static final double alpha = MainView.width/3.5;
	
	private RectangleView skyView;
	private RectangleView roadView;
	//private ShipView shipView;
	//private TruckView truckView;
	//private LoadingDockView loadingDockView;
	
	public SeaPortView() {
		this.skyView = new RectangleView(0, 0, MainView.width, portStartY, Color.PALETURQUOISE);
		this.roadView = new RectangleView(0, portStartY, MainView.width, MainView.height, Color.DIMGRAY);
				
		/*if (ship != null) {
			this.shipView = new ShipView(ship);
		}
		else {
			this.shipView = null;
		}
		
		if (truck != null) {
			this.truckView = new TruckView(truck);
		}
		else {
			this.truckView = null;
		}
		
		this.loadingDockView = new LoadingDockView(port.getLoadingDock(), TruckView.x + alpha, portStartY);*/
	}
	
	public void show(Group root) {		
		root.getChildren().addAll(this.skyView.getShape(), this.roadView.getShape());
		
	/*	if (this.shipView != null) {
			this.shipView.show(root);
		}
		
		if (this.truckView != null) {
			this.truckView.show(root);
		}
		
		this.loadingDockView.show(root);*/
	}
}
