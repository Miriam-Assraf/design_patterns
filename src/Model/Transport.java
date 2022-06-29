package Model;

enum LoadState {
	READY,
	NOT_READY
}


public abstract class Transport {
	private int id;
	/* ------------------------------------Bridge--------------------------------------- */
	private LoadingDock loadingDock;
	/* --------------------------------------------------------------------------------- */
	private SeaPort currentPort;
	private LoadState state;
	
	public Transport(int id, SeaPort currentPort, int numStacks, int stackCapacity) {
		this.id = id;
		this.currentPort = currentPort;
		this.state = LoadState.NOT_READY;
		this.loadingDock = new LoadingDock(numStacks, stackCapacity);
	}
	
	public Transport(int id, int numStacks, int stackCapacity) {
		this.id = id;
		this.currentPort = new NullSeaPort();
		this.state = LoadState.NOT_READY;
		if (stackCapacity > 0) {
			this.loadingDock = new LoadingDock(numStacks, stackCapacity);
		}
		else {
			this.loadingDock = new LoadingDock(numStacks);
		}
	}
	
	public void enterPort(NotNullSeaPort port, int numStacks) {
		this.setPort(port);
		this.loadingDock = new LoadingDock(numStacks);
	}
	
	public void leavePort() {
		this.setPort(new NullSeaPort());
	}
	
	public LoadingDock getLoadingDock() {
		return this.loadingDock;
	}
	
	public int getId() {
		return this.id;
	}
	
	public SeaPort getPort() {
		return this.currentPort;
	}
	
	public void setPort(SeaPort port) {
		this.currentPort = port;
	}
	
	public LoadState getState() {
		return this.state;
	}
	
	public void setState(LoadState state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.id) + ": " + this.loadingDock.toString() + "\n";
	}
}
