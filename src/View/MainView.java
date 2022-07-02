package View;

import java.util.ArrayList;
import java.util.List;

import Enums.ButtonsName;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView {
	public static final int width = 800;
	public static final int height = 600;
	
	private Group root;
	private Scene scene;
	//private ArrayList<Observer> observers = new ArrayList<Observer>();
	private SeaPortView portView;
	private MenuView menuView;
	
	public MainView(Stage stage) {
		this.root = new Group();
		this.scene = new Scene(root, width, height);
		stage.setScene(scene);
		stage.show();
	
		this.portView = new SeaPortView();
		
		ArrayList<String> buttonNames = new ArrayList<String>();
		for (ButtonsName btnName : ButtonsName.values()) { 
			buttonNames.add(btnName.toString());
		}
		if (buttonNames.size() > 0) {
			this.menuView = new MenuView(buttonNames);
		}
	}
	
	public Group getRoot() {
		return this.root;
	}
	
	public Scene getScene() {
		return this.scene;
	}
	
	public void show() {
		this.portView.show(this.root);
		this.menuView.show(this.root);
	}
	
	public MenuView getButtons() {
		return this.menuView;
	}

	//public void refreshView() {
	//	this.root.getChildren().clear();
	//	this.show();
	//}
	
	//public Group getRoot() {
	//	return this.root;
	//}
}
