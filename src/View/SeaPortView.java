package View;

import Model.NotNullSeaPort;
import Model.Ship;
import Model.ShipManager;
import Model.Track;
import Model.TrackManager;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class SeaPortView {
	public static final double portStartY = 2*MainView.height/3;
	private NotNullSeaPort port;
	private ShipManager shipManager;
	private TrackManager trackManager;
	
	public SeaPortView(NotNullSeaPort port) {
		this.port = port;
		this.shipManager = ShipManager.getInstance();
		this.trackManager = TrackManager.getInstance();
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
		
		Track track = this.trackManager.getReadyTrack(this.port);
		if (track != null) {
			TrackView trackView = new TrackView(track);
			trackView.show(root);
		}
		
		// shipView.getWidth()
		AllStacksView stacksView = new AllStacksView(port.getLoadingDock(), ShipView.x1, portStartY);
		stacksView.show(root);
	}
}
