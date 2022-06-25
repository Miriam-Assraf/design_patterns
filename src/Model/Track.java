package Model;

import javafx.scene.paint.Color;

public class Track extends Car {
	ContainersStack containers;
	SeaPort currentPort;
	
	public Track(int size, int capacity, SeaPort currentPort) {
		super(size);
		this.containers = new ContainersStack(capacity);
		this.currentPort = currentPort;
	}

	public Track(int size, Color color, int capacity, SeaPort currentPort) {
		super(size, color);
		this.containers = new ContainersStack(capacity);
		this.currentPort = currentPort;
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
			((NotNullSeaPort) this.currentPort).removeTrack(this);
		}
		this.currentPort = port;
		port.addTrack(this);
	}
	
	public void leavePort() {
		if (!this.currentPort.isNull()) {
			this.currentPort = new NullSeaPort();
		}
	}
}
