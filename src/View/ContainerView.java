package View;

import Model.Container;
import Model.ContainerState;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class ContainerView {
	Container container;
	
	public static final double width = MainView.width/10;
	public static final double height = (MainView.height-SeaPortView.portStartY)/6;
	
	private double x,y;
	
	public ContainerView(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void show(Group root) {
		RectangleView containerView = new RectangleView(this.x, this.y, width, height);
		root.getChildren().add(containerView.getShape());
		
		/*if (this.container.getState() == ContainerState.MARKED) {
			containerView.setStroke(Color.RED);
		}
		else {
			containerView.setStroke(Color.TRANSPARENT);
		}*/
		/*
		if (mark) {
			Line line0 = new Line(x, y, x + width, y);
			line0.setStrokeWidth(3);
			line0.setStroke(Color.RED);
			Line line1 = new Line(x, y + heigth, x + width, y + heigth);
			line1.setStrokeWidth(3);
			line1.setStroke(Color.RED);
			Line line2 = new Line(x, y, x, y + heigth);
			line2.setStrokeWidth(3);
			line2.setStroke(Color.RED);
			Line line3 = new Line(x + width, y, x + width, y + heigth);
			line3.setStrokeWidth(3);
			line3.setStroke(Color.RED);
			root.getChildren().addAll(line0, line1, line2, line3);
		}*/
		
		//root.getChildren().addAll(containerView.getShape());
		//double spaceLine = width * 0.1;
		//double num0fLine = width / spaceLine;
	}
}
