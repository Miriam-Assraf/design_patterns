package Model;

import DesignPatterns.CommandManager;

public class NotNullSeaPort extends SeaPort{
	private String name;
	private String country;
	private LoadingDock loadingDock;
	private CommandManager commandManager;
	
	public NotNullSeaPort(String name, String country, int maxStackSize) {
		this.name = name;
		this.country = country;
		this.loadingDock = new LoadingDock(maxStackSize);
		this.commandManager = new CommandManager();
	}

	public NotNullSeaPort(String name, String country) {
		this.name = name;
		this.country = country;
		this.loadingDock = new LoadingDock(5);
		this.commandManager = new CommandManager();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}
	
	public LoadingDock getLoadingDock() {
		return this.loadingDock;
	}
	
	public CommandManager getCommandManager() {
		return this.commandManager;
	}
	
	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public String toString() {
		return "Port " + this.name + ", " + this.country + ": " + String.valueOf(this.loadingDock.getNumContainers()) + " containers in loading dock.\n";
	}
}
