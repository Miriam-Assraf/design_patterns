package Model;

import java.util.Random;
import javafx.scene.paint.Color;

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
