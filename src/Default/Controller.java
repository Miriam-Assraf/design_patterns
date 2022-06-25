package Default;

import Model.IContainer;
import Model.LoadingDock;
import Model.Model;
import Model.NotNullSeaPort;
import Model.Ship;
import Model.Track;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

	private NotNullSeaPort port;
	private MainView modelView;

	public Controller(NotNullSeaPort port, MainView mainView) {
		this.port = port;
		this.modelView = mainView;
		/*	
		port.addShips(new Ship<IContainer<Object>>(200, 400, 400, 80, 15));
		port.addTrack(new Track<IContainer>(300, 405, 200, 60, 0));
		port.addLodaDock(new LoadingDock<IContainer>(600, 480));
		
		
		for (int i = 0; i < 20; i++) { // adding containers to ship
			port.addContainerToShip();
		}

		Button move = new Button("move");
		move.setLayoutX(700);
		move.setLayoutY(200);
		
		move.setOnAction(new EventHandler<ActionEvent>() {

			int preesNumber = 0;

			@Override
			public void handle(ActionEvent arg0) {

				IContainer tempCon = port.moveContainers();
				boolean containerBack = false;

				if (!containerBack && tempCon != null) {
					if (!tempCon.isMark()) {
						port.addToLoadContainer(tempCon);
					} else {
						tempCon.setMark(false);
						port.addContainerToTrack(tempCon);
						containerBack = true;
					}
				} else if (port.getLoadContainer().getSizeStack() > 0) {
					port.backContainerToship(port.removeContainerFromLoad());
				}
				mainView.clear();
				mainView.show();
				mainView.addButoon(move);
			}
		});

		EventHandler<MouseEvent> click = new EventHandler<MouseEvent>() {
			boolean stop = false;

			@Override
			public void handle(MouseEvent mouse) {

				if (!stop) {
					int locatedX = (int) mouse.getX();
					int locatedY = (int) mouse.getY();

					if (port.addMarkToContainerByIndex(locatedX, locatedY, true)) {
						stop = true;
						mainView.clear();
						mainView.show();
						mainView.addButoon(move);
					}
				}
			}
		};

*/
		//mainView.show();
		//mainView.addButoon(move);
		//mainView.addEventHandler(click);
	}
}
