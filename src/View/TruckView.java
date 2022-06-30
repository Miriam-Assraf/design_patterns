package View;

import Model.Truck;
import javafx.scene.Group;
import javafx.scene.paint.Color;
	
class TruckView {
	public static final double x = MainView.width/3;
	public static final double width = MainView.width/15;
	public static final double y = SeaPortView.portStartY - (MainView.height-SeaPortView.portStartY)/6; // y-h
	public static final double height = (MainView.height-SeaPortView.portStartY)/3;
	
	public static final double alpha = width/2;
	
	private static final double wheelRadius = width/20;
	private Truck truck;
	
	public TruckView(Truck track) {
		this.truck = track;
	}
	
	public void show(Group root) {		
		//RectangleView windowView = new RectangleView(x + (0.2 * x), y + (y * 0.25), (width * 0.2) * 0.6, height * 0.2, Color.WHITE);
		RectangleView cabinView = new RectangleView(x, y, width, height);

		LoadingDockView loadingDockView = new LoadingDockView(this.truck.getLoadingDock(), x + width + alpha, y + height - height/4);
		loadingDockView.show(root);
		
		RectangleView trailerView = new RectangleView(x + width, y + height - height/4, loadingDockView.getWidth() + 2*alpha, height/4, cabinView.getColor());
		root.getChildren().addAll(cabinView.getShape(), trailerView.getShape());
		
		WheelView frontWheelView = new WheelView(x + width * 0.45 + wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.15));
		WheelView middleWheelView = new WheelView(x + width + loadingDockView.getWidth() * 0.6 + 2 * alpha - 2*wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.13));
		WheelView backWheelView = new WheelView(x + width + loadingDockView.getWidth() * 0.85 + 2 * alpha - wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.13));
		
		frontWheelView.show(root);
		middleWheelView.show(root);
		backWheelView.show(root);
	}
}