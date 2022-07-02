package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.NotNullSeaPort;
import Model.Ship;
import Model.Truck;
import View.MainView;
//import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		TransportationFacade facade = new TransportationFacade();
		// Add ports
		ArrayList<Pair<String, String>> ports = new ArrayList<Pair<String, String>>();
		ports.add(new Pair<>("Tel-Aviv Port", "Israel"));
		ports.add(new Pair<>("Haifa Port", "Israel"));
		facade.addPorts(ports);
		System.out.print(facade.printAllPorts());
		
		NotNullSeaPort telAvivPort = facade.getPortByName("Tel-Aviv Port");
		
		// Add ships to port
		facade.addShipsToPort(telAvivPort, new ArrayList<Pair<Integer, Integer>>(List.of(new Pair<Integer, Integer>(5,4))), true);
		System.out.print(facade.printPort(telAvivPort));
		System.out.print(facade.printShipsInPort(telAvivPort));
		System.out.print(facade.printTracksInPort(telAvivPort));
		
		facade.addTrucksToPort(telAvivPort, new ArrayList<Pair<Integer, Integer>>(List.of(new Pair<Integer, Integer>(1,2))), false);
		System.out.print(facade.printPort(telAvivPort));
		System.out.print(facade.printShipsInPort(telAvivPort));
		System.out.print(facade.printTracksInPort(telAvivPort));
		
		MouseManager mouseManager = new MouseManager();
		Controller controller = new Controller(stage, mouseManager, telAvivPort, facade);
	}
}
