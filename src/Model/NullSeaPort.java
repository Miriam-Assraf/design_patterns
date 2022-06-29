package Model;

public class NullSeaPort extends SeaPort{

	@Override
	public boolean isNull() {
		return true;
	}
	
	@Override
	public String toString() {
		return "NullSeaPort object";
	}
}
