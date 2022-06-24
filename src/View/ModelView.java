package View;

import Model.Model;
import javafx.scene.Group;

public class ModelView {

	Model model;

	public ModelView(Model m) {
		setModel(m);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void Show(Group root) {
		SeaPortView seaPortView = new SeaPortView(model.getPort());
		seaPortView.show(root);
	}
}
