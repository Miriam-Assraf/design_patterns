package View;

import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class MenuView {
	public static final int height = MainView.height/20;
	public static final int width = MainView.width/5;
	public static final int x = MainView.width/20;
	public static final int y = MainView.height - MainView.height/10;
	
	public static final int alpha = MainView.width/50;
	
	private ArrayList<Button> allButtons = new ArrayList<Button>();
	
	public MenuView(ArrayList<String> names) {
		for (int i=0; i<names.size(); i++) {
			Button btn = new ButtonView(names.get(i), x+i*(width+alpha), y).getButton();
			btn.setPrefHeight(height);
			btn.setPrefWidth(width);
			allButtons.add(btn);
		}
	}

	public void show(Group root) {		
		for (Button btn: allButtons) {
			root.getChildren().add(btn);
		}
	}
	
	public Button getButtonByName(String name) {
		for (Button btn: this.allButtons) {
			if (btn.getText() == name) {
				return btn;
			}
		}
		return null;
	}

}
