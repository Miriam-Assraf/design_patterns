package Default;

import Model.Containerr;
import Model.Model;
import View.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {

	private Model model;
	private MainView modelView;

	public Controller(Model model, MainView mainView) {
		this.model = model;
		this.modelView = mainView;

		model.addShipToPort();
		model.addTrackToPort();
		model.addLodaDock();
		for (int i = 0; i < 20; i++) { // adding containers to ship
			model.addContainter();
		}

		Button move = new Button("move");
		move.setLayoutX(700);
		move.setLayoutY(200);

		move.setOnAction(new EventHandler<ActionEvent>() {

			int preesNumber = 0;

			@Override
			public void handle(ActionEvent arg0) {

				Containerr tempCon = model.moveContainers();
				boolean containerBack = false;

				if (!containerBack && tempCon != null) {
					if (!tempCon.isMark()) {
						model.addContainerToLodingDock(tempCon);
					} else {
						tempCon.setMark(false);
						model.addContainerToTrack(tempCon);
						containerBack = true;
					}
				} else if (model.getNumOFContainerInLodaDock() > 0) {
					model.backContainerToship(model.removeContainerFromDock());
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

					if (model.addMarkToContainerByIndex(locatedX, locatedY, true)) {
						stop = true;
						mainView.clear();
						mainView.show();
						mainView.addButoon(move);
					}
				}
			}
		};

		mainView.show();
		mainView.addButoon(move);
		mainView.addEventHandler(click);
	}
}
