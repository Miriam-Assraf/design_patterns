package View;

import Model.Truck;
import javafx.scene.Group;
import javafx.scene.paint.Color;
	
public class TruckView {
	public static final Color color = Color.DARKSLATEGRAY;
	public static final double x = MainView.width/3;
	public static final double width = MainView.width/15;
	public static final double y = SeaPortView.portStartY - (MainView.height-SeaPortView.portStartY)/6; // y-h
	public static final double height = (MainView.height-SeaPortView.portStartY)/3;
	public static final double alpha = width/2;
	
	private static final double wheelRadius = width/20;
	private RectangleView cabinView;
	//private LoadingDockView loadingDockView;
	private RectangleView trailerView;
	private WheelView frontWheelView;
	private WheelView middleWheelView;
	private WheelView backWheelView;
	
	public TruckView(double loadingDockWidth) {
		this.cabinView = new RectangleView(x, y, width, height, color);
		//this.loadingDockView = new LoadingDockView(truck.getLoadingDock(), x + width + alpha, y + height - height/4);
		this.trailerView = new RectangleView(x + width, y + height - height/4, loadingDockWidth + 2*alpha, height/4, color);
		this.frontWheelView = new WheelView(x + width * 0.45 + wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.15));
		this.middleWheelView = new WheelView(x + width + loadingDockWidth * 0.6 + 2 * alpha - 2*wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.13));
		this.backWheelView = new WheelView(x + width + loadingDockWidth * 0.85 + 2 * alpha - wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.13));
	}
	
	public void show(Group root) {		
		//this.loadingDockView.show(root);
		root.getChildren().addAll(this.cabinView.getShape(), this.trailerView.getShape());

		this.frontWheelView.show(root);
		this.middleWheelView.show(root);
		this.backWheelView.show(root);
	}
}