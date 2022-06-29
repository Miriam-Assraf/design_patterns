package Model;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.paint.Color;

public class Ship extends Transport {
	private static int idSerial = 0;
	
	public Ship(SeaPort currentPort, int numStacks, int stackCapacity) {
		super(idSerial++, currentPort, numStacks, stackCapacity);
	}
	
	public Ship(SeaPort currentPort, int numStacks) {
		super(idSerial++, currentPort, numStacks, 0);
	}
	
	public Ship(SeaPort currentPort) {
		super(idSerial++, currentPort, 1, 0);
	}
	
	public Ship(int numStacks, int stackCapacity) {
		super(idSerial++, new NullSeaPort(), numStacks, stackCapacity);
	}
	
	public Ship(int numStacks) {
		super(idSerial++, new NullSeaPort(), numStacks, 0);
	}
	
	@Override
	public String toString() {
		return "Ship " + super.toString();
	}
}
