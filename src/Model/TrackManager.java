package Model;

import java.util.ArrayList;

public class TrackManager {
	private static TrackManager instance = null;
	ArrayList<Track> tracks;

	/* ---------------------------------Singleton-------------------------------------- */
	private TrackManager() {
		this.tracks = new ArrayList<Track>();
	}
	
	public static TrackManager getInstance() {
		if (instance == null) {
			instance = new TrackManager();
		}
		return instance;
	}
	/* --------------------------------------------------------------------------------- */
	
	/* ----------------------------------Factory---------------------------------------- */
	public void createTrack(SeaPort currentPort, int numStacks, int stackCapacity) {
		this.tracks.add(new Track(currentPort, numStacks, stackCapacity));
	}
	
	public void createTrack(SeaPort currentPort, int numStacks) {
		this.tracks.add(new Track(currentPort, numStacks));
	}
	
	public void createTrack(SeaPort currentPort) {
		this.tracks.add(new Track(currentPort, 1));
	}
	
	
	public void removeTrack(Track track) {
		this.tracks.remove(track);
	}
	/* --------------------------------------------------------------------------------- */
	
	public Track getTrackById(int id) {
		/* Receives id */
		/* Returns ship with that id if exists, else null */
		for (Track track: this.tracks) {
			if (track.getId() == id) {
				return track;
			}
		}
		return null;
	}
	
	public ArrayList<Track> getTracks() {
		return this.tracks;
	}
	
	public ArrayList<Track> getTracksByPort(NotNullSeaPort port) {
		/* Receives NotNullSeaPort port */
		/* Returns a list of ships in that port if any, else empty list */
		ArrayList<Track> tracks = new ArrayList<Track>();
		for (Track track: this.tracks) {
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
	
	public Track getReadyTrack(NotNullSeaPort port) {
		ArrayList<Track> tracksInPort = getTracksByPort(port);
		
		for (Track track: tracksInPort) {
			if (track.getState() == LoadState.READY) {
				return track;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (Track track: this.tracks) {
			str.append(track.toString());
		}
		
		return str.toString();
	}
}