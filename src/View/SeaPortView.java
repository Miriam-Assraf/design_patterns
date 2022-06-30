package View;

import Model.NotNullSeaPort;
import Model.Ship;
import Model.ShipManager;
import Model.Truck;
import Model.TruckManager;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class SeaPortView {
	public static final double portStartY = 2*MainView.height/3;
	public static final double alpha = MainView.width/5;
	
	private NotNullSeaPort port;
	private ShipManager shipManager;
	private TruckManager trackManager;
	
	public SeaPortView(NotNullSeaPort port) {
		this.port = port;
		this.shipManager = ShipManager.getInstance();
		this.trackManager = TruckManager.getInstance();
	}

	public void show(Group root) {		
		RectangleView skyView = new RectangleView(0, 0, MainView.width, portStartY, Color.LIGHTBLUE);
		RectangleView roadView = new RectangleView(0, portStartY, MainView.width, MainView.height, Color.GRAY);
		
		root.getChildren().addAll(skyView.getShape(), roadView.getShape());
		
		Ship ship = this.shipManager.getReadyShip(this.port);
		if (ship != null) {
			ShipView shipView = new ShipView(ship);
			shipView.show(root);
		}
		
		Truck track = this.trackManager.getReadyTrack(this.port);
		if (track != null) {
			TruckView trackView = new TruckView(track);
			trackView.show(root);
		}
		
		LoadingDockView loadingDockView = new LoadingDockView(this.port.getLoadingDock(), TruckView.x + alpha, portStartY);
		loadingDockView.show(root);
	}
}
