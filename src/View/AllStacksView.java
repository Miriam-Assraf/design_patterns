package View;

import Model.ContainersStack;
import Model.LoadingDock;
import javafx.scene.Group;

public class AllStacksView {
	private double x,y;
	private LoadingDock loadingDock;
	
	public AllStacksView(LoadingDock loadingDock, double x, double y) {
		this.loadingDock = loadingDock;
		this.x = x;
		this.y = y;
	}
	
	public void show(Group root) {
		double x = this.x;
		double y = this.y;
		
		for (ContainersStack stack :this.loadingDock.getContainerStacks()) {
			StackView stackView = new StackView(stack, x, y);
			stackView.show(root);
			x += ContainerView.width;
		}
	}
}
