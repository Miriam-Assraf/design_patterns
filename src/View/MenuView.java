package View;

import java.util.ArrayList;

import Model.NotNullSeaPort;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuView {
	public static final int height = MainView.height/20;
	public static final int x = MainView.width/20;
	public static final int y = MainView.width/20;
	
	public static final int alpha = MainView.width/50;
	
	private ArrayList<Button> allButtons = new ArrayList<Button>();
	
	public MenuView(ArrayList<String> names) {
		for (int i=0; i<names.size(); i++) {
			Button btn = new ButtonView(names.get(i), x, y+i*(height+alpha)).getButton();
			btn.setPrefHeight(height);
			allButtons.add(btn);
		}
	}

	public void show(Group root) {		
		for (Button btn: allButtons) {
			root.getChildren().add(btn);
		}
	}

}
