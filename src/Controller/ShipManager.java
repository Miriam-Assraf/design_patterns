package Controller;

import java.util.ArrayList;

import Enums.LoadState;
import Model.NotNullSeaPort;
import Model.NullSeaPort;
import Model.SeaPort;
import Model.Ship;

public class ShipManager {
	private static ShipManager instance = null;
	ArrayList<Ship> ships;

	/* ---------------------------------Singleton-------------------------------------- */
	private ShipManager() {
		this.ships = new ArrayList<Ship>();
	}
	
	public static ShipManager getInstance() {
		if (instance == null) {
			instance = new ShipManager();
		}
		return instance;
	}
	/* --------------------------------------------------------------------------------- */
	
	/* ----------------------------------Factory---------------------------------------- */
	public void createShip(SeaPort currentPort, int numStacks, int stackCapacity, boolean fill) {
		this.ships.add(new Ship(currentPort, numStacks, stackCapacity, fill));
	}
	
	public void createShip(int numStacks, int stackCapacity, boolean fill) {
		this.ships.add(new Ship(new NullSeaPort(), numStacks, stackCapacity, fill));
	}
	
	public void removeShip(Ship ship) {
		this.ships.remove(ship);
	}
	/* --------------------------------------------------------------------------------- */
	
	public Ship getShipById(int id) {
		/* Receives id */
		/* Returns ship with that id if exists, else null */
		for (Ship ship: this.ships) {
			if (ship.getId() == id) {
				return ship;
			}
		}
		return null;
	}
	
	public ArrayList<Ship> getShips() {
		return this.ships;
	}
	
	public ArrayList<Ship> getShipsByPort(NotNullSeaPort port) {
		/* Receives NotNullSeaPort port */
		/* Returns a list of ships in that port if any, else empty list */
		ArrayList<Ship> ships = new ArrayList<Ship>();
		for (Ship ship: this.ships) {
			if (ship.getPort() == port) {
				ships.add(ship);
			}
		}
		
		if (ships.size() > 0) {
			// set first ship as ready
			ships.get(0).setState(LoadState.READY);
		}
		return ships;
	}
	
	public Ship getReadyShip(NotNullSeaPort port) {
		ArrayList<Ship> shipsInPort = getShipsByPort(port);
		
		for (Ship ship: shipsInPort) {
			if (ship.getState() == LoadState.READY) {
				return ship;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (Ship ship: this.ships) {
			str.append(ship.toString());
		}
		
		return str.toString();
	}
}