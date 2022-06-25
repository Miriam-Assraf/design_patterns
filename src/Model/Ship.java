package Model;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.paint.Color;

public class Ship extends Shape {
	//public static final int MaxHeigth = 5;
	private static int idSerial = 0;
	private int id, width, height; 
	private ListContainersStack containers;
	private SeaPort currentPort;
	
	public Ship(int width, int height, int numStacks, int stackCapacity, SeaPort currentPort) {
		super(width, height);
		this.id = idSerial++;
		this.containers = new ListContainersStack(numStacks, stackCapacity);
		this.currentPort = currentPort;
	}

	public Ship(int width, int height, Color color, int numStacks, int stackCapacity, SeaPort currentPort) {
		super(width, height, color);
		this.id = idSerial++;
		this.containers = new ListContainersStack(numStacks, stackCapacity);
		this.currentPort = currentPort;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void addContainer(Container container) {
		this.containers.load(container);
	}
	
	public Container removeContainer() {
		return this.containers.unload();
	}
	
	public void enterPort(NotNullSeaPort port) {
		if (!this.currentPort.isNull()) {
			// if already in another port - remove from it 
			((NotNullSeaPort) this.currentPort).removeShip(this);
		}
		this.currentPort = port;
		port.addShip(this);
	}
	
	public void leavePort() {
		if (!this.currentPort.isNull()) {
			this.currentPort = new NullSeaPort();
		}
	}
}
