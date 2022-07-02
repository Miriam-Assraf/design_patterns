package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.Container;
import Model.NotNullSeaPort;
import Model.SeaPort;
import Model.Transport;
import javafx.scene.paint.Color;

public class SeaPortManager {
	private static SeaPortManager instance = null;
	ArrayList<NotNullSeaPort> ports;
	
	/* ---------------------------------Singleton-------------------------------------- */
	private SeaPortManager() {
		this.ports = new ArrayList<NotNullSeaPort>();
	}
	
	public static SeaPortManager getInstance() {
		if (instance == null) {
			instance = new SeaPortManager();
		}
		return instance;
	}
	/* --------------------------------------------------------------------------------- */
	
	/* ----------------------------------Factory---------------------------------------- */
	public boolean createPort(String name, String country) {
		boolean success = true;
		
		for (NotNullSeaPort port: this.ports) {
			// name should be unique
			if (port.getName() == name) {
				success = false;
			}
		}
		
		if (success) {
			NotNullSeaPort port = new NotNullSeaPort(name, country);
			this.ports.add(port);
		}
		
		return success;
	}
	
	
	public boolean removePort(NotNullSeaPort port) {
		if (this.ports.contains(port)) {
			this.ports.remove(port);
			return true;
		}
		return false;
	}
	/* --------------------------------------------------------------------------------- */
	
	/* ----------------------------------Mediator-------------------------------------- */
	// ---Communicate between Ship and Track (pass containers through loading dock)--- //
	
	public boolean loadToPort(NotNullSeaPort port, Transport transport) {
		boolean success = false; 
		
		if (transport != null && transport.getPort() == port) {
			Container container = null;
			
			// remove container from object and add it to loading dock
			container = transport.getLoadingDock().removeContainer();	
			
			if (container != null) {
				success = port.getLoadingDock().addContainer(container);
				
				// if can't be added to loading dock (full), return to stack removed from
				if (!success) {
					transport.getLoadingDock().addContainer(container);
				}
				else {
					port.getCommandManager().add(port, transport);
				}
			}
		}
		return success;
	}
	
	public boolean loadFromPort(NotNullSeaPort port, Transport transport) {
		boolean success = false;
		
		if (transport != null && transport.getPort() == port) {
			// remove container from loading dock and add it to object
			Container container = port.getLoadingDock().removeContainer();
			
			if (container != null) {
				success = transport.getLoadingDock().addContainer(container);
				
				// if can't be added to object's stack (full), return it to loading dock
				if (!success) {
					port.getLoadingDock().addContainer(container);
				}
				
				else {
					port.getCommandManager().add(port, transport);
				}
			}
		}
		return success;
	}
	/* --------------------------------------------------------------------------------- */
	
	
	/* -----------------------------------Command--------------------------------------- */
	public void undo(NotNullSeaPort port) {
		port.getCommandManager().undo();
	}
	
	public void redo(NotNullSeaPort port) {
		port.getCommandManager().redo();
	}
	/* --------------------------------------------------------------------------------- */
	
	public NotNullSeaPort getPortByName(String name) {
		/* Receives name string */
		/* Returns port with that name if exists, else null */
		for (NotNullSeaPort port: this.ports) {
			if (port.getName() == name) {
				return port;
			}
		}
		return null;
	}
	
	public ArrayList<NotNullSeaPort> getPortsByCountry(String country) {
		/* Receives country string */
		/* Returns a list of ports in that country if exist, else empty list */
		ArrayList<NotNullSeaPort> ports = new ArrayList<NotNullSeaPort>();
		for (NotNullSeaPort port: this.ports) {
			if (port.getCountry() == country) {
				ports.add(port);
			}
		}
		return ports;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (SeaPort port:this.ports) {
			str.append(port.toString());
		}
		
		return str.toString();
	}
}