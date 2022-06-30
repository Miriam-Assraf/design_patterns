package Model;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.paint.Color;

public class Ship extends Transport {
	private static int idSerial = 0;
	
	public Ship(SeaPort currentPort, int numStacks, int stackCapacity, boolean fill) {
		super(idSerial++, currentPort, numStacks, stackCapacity, fill);
	}
	
	public Ship(int numStacks, int stackCapacity, boolean fill) {
		super(idSerial++, new NullSeaPort(), numStacks, stackCapacity, fill);
	}
	
	@Override
	public String toString() {
		return "Ship " + super.toString();
	}
}
