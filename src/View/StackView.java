package View;

import Model.ContainersStack;
import javafx.scene.Group;

public class StackView {
	private double x,y;
	private int capacity;
	
	public StackView(ContainersStack stack, double x, double y) {
		this.capacity = stack.getNumContainers();
		this.x = x;
		this.y = y;
	}
	
	public void show(Group root) {
		double x = this.x;
		double y = this.y;
		
		for (int i=0; i<this.capacity; i++) {
			ContainerView containerView = new ContainerView(x, y);
			containerView.show(root);
			y += ContainerView.height;
		}
	}
}
