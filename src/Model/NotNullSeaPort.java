package Model;

import java.util.ArrayList;

// Mediator - communicate between 
public class NotNullSeaPort extends SeaPort{
	private String name;
	private String country;
	private LoadingDock loadingDock;
	private ArrayList<Track> tracks;
	private ArrayList<Ship> ships;

	public NotNullSeaPort(String name, String country, int capacity) {
		this.name = name;
		this.country = country;
		this.tracks = new ArrayList<Track>();
		this.ships = new ArrayList<Ship>();
		this.loadingDock = new LoadingDock(capacity);
	}

	public void addTrack(Track track) {
		tracks.add(track);
	}

	public void removeTrack(Track track) {
		tracks.remove(track);
	}

	public void addShip(Ship ship) {
		this.ships.add(ship);
	}

	public void removeShip(Ship ship) {
		ships.remove(ship);
	}

	public ArrayList<Ship> getShips() {
		return ships;
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
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
	
	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String toString() {
		return "Port " + this.name + ", " + this.country + ":\nShips: " + this.ships.toString() + "\nTracks: " + this.tracks.toString() + "\n";
	}
}
