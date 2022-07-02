package Controller;
import java.util.ArrayList;

import DesignPatterns.Observable;
import DesignPatterns.UserInputObserver;
import javafx.scene.Scene;

public abstract class InputManager implements Observable<UserInputObserver> {	
	ArrayList<UserInputObserver> observers = new ArrayList<UserInputObserver>();
	
	public abstract void getUserInput(Scene scene);
	public abstract void notifyObservers();
	public abstract boolean check(double x1, double x2, double y1, double y2);
	
	@Override
	public void attach(UserInputObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void detach(UserInputObserver observer) {
		observers.remove(observer);
		
	}
}
