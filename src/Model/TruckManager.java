package Model;

import java.util.ArrayList;

public class TruckManager {
	private static TruckManager instance = null;
	ArrayList<Truck> tracks;

	/* ---------------------------------Singleton-------------------------------------- */
	private TruckManager() {
		this.tracks = new ArrayList<Truck>();
	}
	
	public static TruckManager getInstance() {
		if (instance == null) {
			instance = new TruckManager();
		}
		return instance;
	}
	/* --------------------------------------------------------------------------------- */
	
	/* ----------------------------------Factory---------------------------------------- */
	public void createTrack(SeaPort currentPort, int numStacks, int stackCapacity, boolean fill) {
		this.tracks.add(new Truck(currentPort, numStacks, stackCapacity, fill));
	}
	
	public void createTrack(int numStacks, int stackCapacity, boolean fill) {
		this.tracks.add(new Truck(new NullSeaPort(), numStacks, stackCapacity, fill));
	}
	
	public void removeTrack(Truck track) {
		this.tracks.remove(track);
	}
	/* --------------------------------------------------------------------------------- */
	
	public Truck getTrackById(int id) {
		/* Receives id */
		/* Returns ship with that id if exists, else null */
		for (Truck track: this.tracks) {
			if (track.getId() == id) {
				return track;
			}
		}
		return null;
	}
	
	public ArrayList<Truck> getTracks() {
		return this.tracks;
	}
	
	public ArrayList<Truck> getTracksByPort(NotNullSeaPort port) {
		/* Receives NotNullSeaPort port */
		/* Returns a list of ships in that port if any, else empty list */
		ArrayList<Truck> tracks = new ArrayList<Truck>();
		for (Truck track: this.tracks) {
			if (track.getPort() == port) {
				tracks.add(track);
			}
		}
		
		if (tracks.size() > 0) {
			// set first track as ready
			tracks.get(0).setState(LoadState.READY);
		}
		return tracks;
	}
	
	public Truck getReadyTrack(NotNullSeaPort port) {
		ArrayList<Truck> tracksInPort = getTracksByPort(port);
		
		for (Truck track: tracksInPort) {
			if (track.getState() == LoadState.READY) {
				return track;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (Truck track: this.tracks) {
			str.append(track.toString());
		}
		
		return str.toString();
	}
}