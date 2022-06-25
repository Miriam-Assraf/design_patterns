package Model;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;

public class Model {
	ArrayList<NotNullSeaPort> ports;

	public Model() {
		this.ports = new ArrayList<NotNullSeaPort>();
	}

	public Model(ArrayList<NotNullSeaPort> ports) {
		this.ports = ports;
	}
	
	public boolean createPort(String name, String country, int capacity) {
		boolean success = true;
		
		for (NotNullSeaPort port: this.ports) {
			// name should be unique
			if (port.getName() == name) {
				success = false;
			}
		}
		
		if (success) {
			this.ports.add(new NotNullSeaPort(name, country, capacity));
		}
		
		return success;
	}
	
	public boolean removePort(NotNullSeaPort port) {
		if (this.ports.contains(port)) {
			this.ports.remove(port);
			return true;
		}
		return false;
	}
	
	public NotNullSeaPort getPortByName(String name) {
		/* Receives name string */
		/* Returns port with that name if exists, else null */
		for (NotNullSeaPort port: this.ports) {
			if (port.getName() == name) {
				return port;
			}
		}
		return null;
	}
	
	public ArrayList<NotNullSeaPort> getPortsByCountry(String country) {
		/* Receives country string */
		/* Returns a list of ports in that country if exist, else empty list */
		ArrayList<NotNullSeaPort> ports = new ArrayList<NotNullSeaPort>();
		for (NotNullSeaPort port: this.ports) {
			if (port.getCountry() == country) {
				ports.add(port);
			}
		}
		return ports;
	}
	
	//public void addShipToPort(String name) {
	//	getPortByName(name).addShips();
	//}
}
/*
	public static Color RandomColor() {
		Random random = new Random();
		return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}


public class Model {
	SeaPort port;

	public Model() {
		port = new SeaPort();
	}

	public Model(String portName, String country) {
		port = new SeaPort(portName, country);
	}

	public void addLodaDock() {
		port.addLodaDock();
	}

	public int getNumOFContainerInLodaDock() {
		return port.getLoadContainer().getSizeStack();
	}

	public int getMaxheigth() {
		return port.getMaxheigth();
	}

	public void addTrackToPort() {
		port.addTracks();
	}

	public void addContainter() {
		port.addContainerToShip();
	}

	public void removeTrackFromPort() {
		port.removeTracks();
	}

	public void addShipToPort() {
		port.addShips();
	}

	public void removeShipFromPort() {
		port.removeShip();
	}

	public void addContainterToTrack(int x, int y) {
		port.addContainerToTrack(x, y);
	}

	public void addContainerToLodingDock(Containerr container) {
		port.addToLoadContainer(container);
	}

	public boolean addContainerToTrack(Containerr containerr) {
		return port.addContainerToTrack(containerr);
	}

	public Containerr removeContainerFromDock() {
		return port.removeContainerFromLoad();
	}

	public Containerr moveContainers() {
		return port.moveContainers();
	}

	public void backContainerToship(Containerr c) {
		port.backContainerToship(c);

	}

	public boolean addContainerToShip(int indexStack, Containerr C) {
		return port.addContainerToShipByIndex(indexStack, C);
	}

	public Containerr removeContainerToShip(int x, int y) {
		return port.removeContainerFromShipByIndex(x, y);
	}

	public boolean addMarkToContainerByIndex(int x, int y, boolean mark) {
		return port.getShips().get(0).markContainerByCoords(x, y, mark);
	}

	public Containerr removeContainerFromShipByIndex(int x, int y) {
		return port.removeContainerFromShipByIndex(x, y);
	}

	public Containerr removeContainersToStackNumber(int stackNumber) {
		return port.removeContainersToStackNumber(stackNumber);
	}

	public int[] getLocatedStackMarkContainer() {
		return port.getLocatedStackMarkContainer();
	}

	public void addLoad() {
		port.addLodaDock();
	}

	public SeaPort getPort() {
		return port;
	}

	public void setPort(SeaPort port) {
		this.port = port;
	}

	public static Color RandomColor() {
		Random random = new Random();
		return Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
*/