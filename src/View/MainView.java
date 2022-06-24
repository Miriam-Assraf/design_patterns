package View;

import Model.Model;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.VideoTrack;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainView {
	private Stage stage;
	private Group root;
	private Scene scene;
	private Model m1;
	private ModelView modelView;

	public MainView(Model m, Stage s) {
		this.m1 = m;
		stage = s;
		root = new Group();
		scene = new Scene(root, 900, 900);
		stage.setScene(scene);
		stage.show();
		this.modelView = new ModelView(m1);
	}

	public void show() {
		modelView.Show(root);
	}

	public void clear() {
		root.getChildren().clear();
	}

	public void addButoon(Button b) {
		root.getChildren().add(b);
	}

	public void addEventHandler(EventHandler<MouseEvent> e) {
		stage.addEventHandler(MouseEvent.MOUSE_CLICKED, e);
	}
}
