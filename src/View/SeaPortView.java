package View;

import java.util.ArrayList;
import Model.Containerr;
import Model.LoadingDock;
import Model.SeaPort;
import Model.Ship;
import Model.Track;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SeaPortView {

	private String name;
	private String country;
	private LoadingDock loadContainer;
	private ArrayList<Track> tracks;
	private ArrayList<Ship> ships;

	public SeaPortView(SeaPort seaPort) {
		setName(seaPort.getName());
		setCountry(seaPort.getCountry());
		setLoadContainer(seaPort.getLoadContainer());
		setTracks(seaPort.getTracks());
		setShips(seaPort.getShips());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Containerr getLoadContainer() {
		return (Containerr) loadContainer.getContainer();
	}

	public void setLoadContainer(LoadingDock<Containerr> container) {
		this.loadContainer = container;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public void setShips(ArrayList<Ship> ships) {
		this.ships = ships;
	}

	public ArrayList<Ship> getShips() {
		return this.ships;
	}

	public void show(Group root) {
		Rectangle sky = new Rectangle(0, 0, 1500, ships.get(0).getY() + ships.get(0).getHeight());
		sky.setFill(Color.LIGHTBLUE);
		root.getChildren().add(sky);

		Rectangle road = new Rectangle(0, ships.get(0).getY() + ships.get(0).getHeight(), 1500, 1500);
		road.setFill(Color.GRAY);
		root.getChildren().add(road);

		ShipView shipView = new ShipView((ships.get(0)));
		shipView.show(root);

		TrackView trackView = new TrackView(tracks.get(0));
		trackView.show(root);

		LoadingDockView dock = new LoadingDockView(loadContainer);
		dock.show(root);
	}
}
