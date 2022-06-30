package View;

import javafx.scene.Group;
import javafx.scene.control.Button;

public class ButtonView {
	private Button button;
	
	public ButtonView(String name, double x, double y) {
		this.button = new Button(name);
		this.button.setLayoutX(x);
		this.button.setLayoutY(y);
	}
	
	public Button getButton() {
		return this.button;
	}
}
