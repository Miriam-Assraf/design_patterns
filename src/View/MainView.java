package View;

import java.util.ArrayList;
import java.util.List;

import Model.NotNullSeaPort;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView {
	public static final int width = 800;
	public static final int height = 600;
	
	private Group root;
	
	public MainView(Stage stage) {
		this.root = new Group();
		stage.setScene(new Scene(root, width, height));
		stage.show();
	}

	public void show(NotNullSeaPort port) {
		SeaPortView portView = new SeaPortView(port);
		MenuView menuView = new MenuView(new ArrayList<String>(List.of("Move","Undo","Redo")));
		
		portView.show(this.root);
		menuView.show(this.root);
	}

	public void clear() {
		root.getChildren().clear();
	}

	/*public void addButoon(Button b) {
		root.getChildren().add(b);
	}

	public void addEventHandler(EventHandler<MouseEvent> e) {
		stage.addEventHandler(MouseEvent.MOUSE_CLICKED, e);
	}*/
}
