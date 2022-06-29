package Model;

public class Track extends Transport {
	private static int idSerial = 0;
	
	public Track(SeaPort currentPort, int numStacks, int stackCapacity) {
		super(idSerial++, currentPort, numStacks, stackCapacity);
	}

	public Track(SeaPort currentPort, int numStacks) {
		super(idSerial++, currentPort, numStacks, 0);
	}
	
	public Track(SeaPort currentPort) {
		super(idSerial++, currentPort, 1, 0);
	}
	
	public Track(int numStacks, int stackCapacity) {
		super(idSerial++, new NullSeaPort(), numStacks, stackCapacity);
	}
	
	public Track(int numStacks) {
		super(idSerial++, new NullSeaPort(), numStacks, 0);
	}
	
	@Override
	public String toString() {
		return "Track " + super.toString();
	}
}
