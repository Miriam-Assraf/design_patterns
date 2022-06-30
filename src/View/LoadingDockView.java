package View;

import Model.ContainersStack;
import Model.LoadingDock;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class LoadingDockView {
	private static final double alpha = ContainerView.width * 0.1;
	private LoadingDock loadingDock;
	private double x; 
	private double y;
	private double width;
	
	LoadingDockView(LoadingDock loadingDock, double x, double y) {
		this.x = x;
		this.y = y;
		this.width = loadingDock.getNumStacks() * ContainerView.width + (loadingDock.getNumStacks() - 1) * alpha;
		this.loadingDock = loadingDock;		
	}
	
	public void show(Group root) {	
		Line line = new Line(this.x, this.y, this.x + this.width, this.y);
		root.getChildren().add(line);
		
		int currStack = 0;
		for (ContainersStack stack: this.loadingDock.getContainerStacks()) {
			StackView stackView = new StackView(stack, x + currStack*(ContainerView.width + alpha), y-ContainerView.height);
			stackView.show(root);
			currStack++;
		}
	}
	
	public double getWidth() {
		return this.width;
	}
}
