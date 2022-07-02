package Controller;

import java.util.ArrayList;

import DesignPatterns.Observable;
import DesignPatterns.UserInputObserver;
import View.ContainerView;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class MouseManager extends InputManager {
	private ArrayList<UserInputObserver> observers = new ArrayList<UserInputObserver>();
	private double clickedX, clickedY;
	
	@Override
	public void getUserInput(Scene scene) {
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {		    
		    	clickedX = mouseEvent.getX();
		    	clickedY = mouseEvent.getY();
		    	notifyObservers();
		    }
		});
	}

	@Override
	public void notifyObservers() {
		for (UserInputObserver observer: observers) {
			observer.handle();
		}
	}

	@Override
	public boolean check(double x1, double x2, double y1, double y2) {
		if (x1<=this.clickedX && this.clickedX<=x2 && y1<=this.clickedY && this.clickedY<= y2) {
			return true;
		}
		return false;
	}
}
