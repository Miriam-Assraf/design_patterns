package Model;

import java.util.ArrayList;
import javafx.util.Pair;

/* ------------------------------------Facade--------------------------------------- */
public class TransportationFacade {
	private SeaPortManager portsManager;
	private ShipManager shipsManager;
	private TruckManager tracksManager;
	
	public TransportationFacade() {
		this.portsManager = SeaPortManager.getInstance();
		this.shipsManager = ShipManager.getInstance();
		this.tracksManager = TruckManager.getInstance();
	}
	
	public void addPorts(ArrayList<Pair<String, String>> portsData) {
		// Receives list of pairs containing port name and port country
		for (int i=0; i<portsData.size(); i++) {
			portsManager.createPort(portsData.get(i).getKey(), portsData.get(i).getValue());
		}
	}
	
	// Add without port
	public void addShips(ArrayList<Pair<Integer, Integer>> shipsData, boolean fill) {
		// Receives list of pairs containing for each ship numStacks and stackCapacity
		NullSeaPort port = new NullSeaPort();
		for (int i=0; i<shipsData.size(); i++) {
			shipsManager.createShip(port, shipsData.get(i).getKey(), shipsData.get(i).getValue(), fill);
		}
	}
	
	public void addTracks(ArrayList<Pair<Integer, Integer>> tracksData, boolean fill) {
		// Receives list of pairs containing for each track numStacks and stackCapacity
		NullSeaPort port = new NullSeaPort();
		for (int i=0; i<tracksData.size(); i++) {
			tracksManager.createTrack(port, tracksData.get(i).getKey(), tracksData.get(i).getValue(), fill);
		}
	}
	
	// Add to port by data
	public void addShipsToPort(NotNullSeaPort port, ArrayList<Pair<Integer, Integer>> shipsData, boolean fill) {
		for (int i=0; i<shipsData.size(); i++) {
			shipsManager.createShip(port, shipsData.get(i).getKey(), shipsData.get(i).getValue(), fill);
		}
		
	}
	
	public void addTracksToPort(NotNullSeaPort port, ArrayList<Pair<Integer, Integer>> tracksData, boolean fill) {
		for (int i=0; i<tracksData.size(); i++) {
			tracksManager.createTrack(port, tracksData.get(i).getKey(), tracksData.get(i).getValue(), fill);
		}
	}
	
	// ports manager
	public NotNullSeaPort getPortByName(String name) {
		return portsManager.getPortByName(name);
	}
	
	public ArrayList<NotNullSeaPort> getPortsByCountry(String country) {
		return portsManager.getPortsByCountry(country);
	}
	
	public String printAllPorts() {
		return portsManager.toString();
	}
	
	public String printPort(SeaPort port) {
		return port.toString();
	}
	
	protected Ship getReadyShip(NotNullSeaPort port) {
		ArrayList<Ship> shipsInPort = getShipsByPort(port);
		
		for (Ship ship: shipsInPort) {
			if (ship.getState() == LoadState.READY) {
				return ship;
			}
		}
		return null;
	}
	
	public void markShipContainer(NotNullSeaPort port, int numStack, int numContainer) {
		Ship ship = getReadyShip(port);
		ship.getLoadingDock().markContainer(numStack, numContainer);
	}
	
	public boolean loadFromShip(NotNullSeaPort port) {
		Transport ship = getReadyShip(port);
		return this.portsManager.loadToPort(port, ship);
	}
	
	public boolean loadToShip(NotNullSeaPort port) {
		Transport ship = getReadyShip(port);
		return this.portsManager.loadFromPort(port, ship);
	}
	
	protected Truck getReadyTrack(NotNullSeaPort port) {
		ArrayList<Truck> tracksInPort = getTracksByPort(port);
		
		for (Truck track: tracksInPort) {
			if (track.getState() == LoadState.READY) {
				return track;
			}
		}
		return null;
	}
	
	public void markTrackContainer(NotNullSeaPort port, int numStack, int numContainer) {
		Truck track = getReadyTrack(port);
		track.getLoadingDock().markContainer(numStack, numContainer);
	}
	
	public boolean loadFromTrack(NotNullSeaPort port) {
		Transport track = getReadyTrack(port);
		return this.portsManager.loadToPort(port, track);
	}
	
	public boolean loadToTrack(NotNullSeaPort port) {
		Transport track = getReadyTrack(port);
		return this.portsManager.loadFromPort(port, track);
	}
	
	// ships manager
	public Ship getShipById(int id) {
		return shipsManager.getShipById(id);
	}
	
	public ArrayList<Ship> getShips() {
		return shipsManager.getShips();
	}
	
	public ArrayList<Ship> getShipsByPort(NotNullSeaPort port) {
		return shipsManager.getShipsByPort(port);
	}
	
	public String printShipsInPort(NotNullSeaPort port) {
		StringBuilder str = new StringBuilder();
		ArrayList<Ship> ships = getShipsByPort(port);
		
		for (Ship ship: ships) {
			str.append(ship.toString());
		}
		
		return str.toString();
	}
	
	public String printAllShips() {
		return shipsManager.toString();
	}
	
	// tracks manager
	public Truck getTrackById(int id) {
		return tracksManager.getTrackById(id);
	}
	
	public ArrayList<Truck> getTracks() {
		return tracksManager.getTracks();
	}
	
	public ArrayList<Truck> getTracksByPort(NotNullSeaPort port) {
		return tracksManager.getTracksByPort(port);
	}
	
	public String printTracksInPort(NotNullSeaPort port) {
		StringBuilder str = new StringBuilder();
		ArrayList<Truck> tracks = getTracksByPort(port);
		
		for (Truck track: tracks) {
			str.append(track.toString());
		}
		
		return str.toString();
	}
	
	public String printAllTracks() {
		return tracksManager.toString();
	}
	
	public void undo(NotNullSeaPort port) {
		this.portsManager.undo(port);
	}
	
	public void redo(NotNullSeaPort port) {
		this.portsManager.redo(port);
	}
}
/* --------------------------------------------------------------------------------- */