package View;

import Model.ContainersStack;
import javafx.scene.Group;

public class StackView {
	private double x,y;
	private int size;
	
	public StackView(ContainersStack stack, double x, double y) {
		this.size = stack.getNumContainers();
		this.x = x;
		this.y = y;
	}
	
	public void show(Group root) {
		double x = this.x;
		double y = this.y;
		
		for (int i=0; i<this.size; i++) {
			ContainerView containerView = new ContainerView(x, y-i*ContainerView.height);
			containerView.show(root);
		}
	}
}
