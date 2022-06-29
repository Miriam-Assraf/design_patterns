package Model;

import java.util.Stack;

public class CommandManager implements ICommand {
	private Stack<Transport> undoTransportStack = new Stack<Transport>();
	private Stack<NotNullSeaPort> undoPortStack = new Stack<NotNullSeaPort>();
	
	private Stack<Transport> redoTransportStack = new Stack<Transport>();
	private Stack<NotNullSeaPort> redoPortStack = new Stack<NotNullSeaPort>();
	
	protected void add(NotNullSeaPort port, Transport transport) {
		this.undoTransportStack.push(transport);
		this.undoPortStack.push(port);
	}
	
	@Override
	public void undo() {
		Transport undoTransport = undoTransportStack.pop();
		NotNullSeaPort undoPort = undoPortStack.pop();
		
		undoTransport.getLoadingDock().undo();
		undoPort.getLoadingDock().undo();
		
		redoTransportStack.push(undoTransport);
		redoPortStack.push(undoPort);
	}
	
	@Override
	public void redo() {
		redoTransportStack.pop().getLoadingDock().redo();
		redoPortStack.pop().getLoadingDock().redo();
	}
	
	
}
