package View;

import Model.Track;
import javafx.scene.Group;
import javafx.scene.paint.Color;
	
class TrackView {
	public static final double x = 300;
	public static final double y = 405;

	public static final double height = 60;
	public static final int alpha = 6;
	
	private static final int wheelRadius = 7;
	private Track track;
	
	public TrackView(Track track) {
		this.track = track;
	}
	
	public void show(Group root) {
		double width = this.track.getLoadingDock().getNumStacks() * ContainerView.width + alpha;
		
		RectangleView windowView = new RectangleView(x + (0.02 * x), y + (y * 0.025), (width * 0.2) * 0.6, height * 0.2, Color.WHITE);
		
		RectangleView cabinView = new RectangleView(x, y, width * 0.2, height);
		RectangleView trailercabinView = new RectangleView(x + width * 0.2, y + height - (height * 0.2), width - (width * 0.2), height * 0.15); //same color

		CircleView leftWheelView = new CircleView(x + width * 0.1, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.075), Color.BLACK);
		CircleView middleWheelView = new CircleView(x + width * 0.35 + wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.075), Color.BLACK);
		CircleView rigthWheelView = new CircleView(x + width - wheelRadius, y + (height * 0.35) + height * 0.65 + wheelRadius, wheelRadius + (height * 0.075), Color.BLACK);
		
		root.getChildren().addAll(windowView.getShape(), cabinView.getShape(), trailercabinView.getShape(), 
				leftWheelView.getShape(), middleWheelView.getShape(), rigthWheelView.getShape());
		
		AllStacksView stacksView = new AllStacksView(track.getLoadingDock(), x+alpha/2, y);
		stacksView.show(root);
	}
}