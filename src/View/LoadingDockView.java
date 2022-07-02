package View;

import java.util.ArrayList;

import Model.ContainersStack;
import Model.LoadingDock;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class LoadingDockView {
	public static final double alpha = ContainerView.width * 0.1;
	private Line line;
	//private ArrayList<StackView> stackViews = new ArrayList<StackView>();
	
	public LoadingDockView(double x, double y, double width) {
		this.line = new Line(x, y, x + width, y);
		
	/*	int currStack = 0;
		for (ContainersStack stack: loadingDock.getContainerStacks()) {
			StackView stackView = new StackView(stack, x + currStack*(ContainerView.width + alpha), y-ContainerView.height);
			stackViews.add(stackView);
			currStack++;
		}*/	
	}
	
	public void show(Group root) {	
		root.getChildren().add(this.line);
		
		/*for (StackView stackView: this.stackViews) {
			stackView.show(root);
		}*/
	}
	
	//public double getWidth() {
	//	return this.width;
	//}
}
