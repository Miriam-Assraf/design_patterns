package Model;

public class Truck extends Transport {
	private static int idSerial = 0;
	
	public Truck(SeaPort currentPort, int numStacks, int stackCapacity, boolean fill) {
		super(idSerial++, currentPort, numStacks, stackCapacity, fill);
	}
	
	public Truck(int numStacks, int stackCapacity, boolean fill) {
		super(idSerial++, new NullSeaPort(), numStacks, stackCapacity, fill);
	}
	
	@Override
	public String toString() {
		return "Track " + super.toString();
	}
}
