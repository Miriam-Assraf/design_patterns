package Controller;

import java.util.ArrayList;
import java.util.List;

import DesignPatterns.ContainerObserver;
import DesignPatterns.UserInputObserver;
import Enums.ButtonsName;
import Enums.TransportType;
import Model.LoadingDock;
import Model.NotNullSeaPort;
import View.ContainerView;
import View.LoadingDockView;
import View.MainView;
import View.SeaPortView;
import View.TruckView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller implements ContainerObserver {
	private MainView mainView; 
	private InputManager inputManager;
	private NotNullSeaPort port;
	private TransportationFacade facade;
	private ShipController shipController;
	private LoadingDockController loadingDockController;
	private TruckController truckController; 
	private ArrayList<String> buttonNames;
	
	public Controller(Stage stage, InputManager inputManager, NotNullSeaPort port, TransportationFacade facade) {		
		this.mainView = new MainView(stage); // window
		this.port = port;
		this.facade = facade;
		
		this.inputManager.getUserInput(this.mainView.getScene());
		
		this.initializeView();
		this.initializeButtons();
	}
	
	public void initializeView() {
		this.shipController = new ShipController(this.inputManager, facade.getReadyShip(this.port));
		if (this.shipController.getLoadingDockController() != null) {
			this.shipController.getLoadingDockController().attach(this);
		}
		
		this.truckController = new TruckController(this.inputManager, facade.getReadyTruck(this.port));
		if (this.truckController.getLoadingDockController() != null) {
			this.truckController.getLoadingDockController().attach(this);
		}
		
		LoadingDock loadingDock = port.getLoadingDock();
		double width = loadingDock.getNumStacks() * ContainerView.width + (loadingDock.getNumStacks() - 1) * LoadingDockView.alpha;		
		this.loadingDockController = new LoadingDockController(this.inputManager, loadingDock, TruckView.x + SeaPortView.alpha, SeaPortView.portStartY, width);
	
		this.updateView();
	}

	public void initializeButtons() {
		loadToPort(TransportType.SHIP);
		loadToPort(TransportType.TRUCK);
		loadFromPort(TransportType.SHIP);
		loadFromPort(TransportType.TRUCK);
	}
	
	@Override
	public void handle(int stackId, int containerId) {
		// arg1 = stackId
		// arg2 = containerId
		this.facade.markContainer(this.port, stackId, containerId);
		this.updateView();
	}
	
	public void updateView() {
		Group root = this.mainView.getRoot();
		root.getChildren().clear();

		this.mainView.show();
		this.shipController.updateView(root);
		this.truckController.updateView(root);
		this.loadingDockController.updateView(root);
	}
	
	public void loadToPort(TransportType type) {
		Button btn = null;
		
		if (type == TransportType.SHIP) {
			btn = this.mainView.getButtons().getButtonByName(ButtonsName.LOADFROMSHIP.toString());
		}
		else if (type == TransportType.TRUCK) {
			btn = this.mainView.getButtons().getButtonByName(ButtonsName.LOADFROMTRUCK.toString());
		}
		
		// observer (observable?)
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				facade.loadToPort(port, type);
				System.out.print(facade.printPort(port));
				System.out.print(facade.printShipsInPort(port));
				System.out.print(facade.printTracksInPort(port));
				updateView();
				
			}
		});
	}
	
	public void loadFromPort(TransportType type) {
		Button btn = null;
		
		if (type == TransportType.SHIP) {
			btn = this.mainView.getButtons().getButtonByName(ButtonsName.LOADTOSHIP.toString());
		}
		else if (type == TransportType.TRUCK) {
			btn = this.mainView.getButtons().getButtonByName(ButtonsName.LOADTOTRUCK.toString());
		}
		
		// observer (observable?)
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				facade.loadFromPort(port, type);
				System.out.print(facade.printPort(port));
				System.out.print(facade.printShipsInPort(port));
				System.out.print(facade.printTracksInPort(port));
				updateView();
				
			}
		});
	}
}
