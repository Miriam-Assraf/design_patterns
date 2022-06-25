package Model;

import java.util.ArrayList;
import javafx.scene.paint.Color;

//State
enum StateE {
	MARKED,
	LOADED,
	PENDING
}

public class Container<T extends Object> extends Shape {
	private static int idSerial = 0;
	private int id;
	private ArrayList<Object> products;
	private StateE state;

	public Container(int width, int height) {
		super(width, height);
		this.id = idSerial++;
		this.products = new ArrayList<Object>();
		this.state = StateE.LOADED;
	}
	
	public Container(int width, int height, Color color) {
		super(width, height, color);
		this.id = idSerial++;
		this.products = new ArrayList<Object>();
		this.state = StateE.LOADED;
	}
	
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Object> getProducts() {
		return this.products;
	}
	
	public StateE getState() {
		return this.state;
	}
	
	public void setState(StateE state) {
		this.state = state;
	}
	
	public void addProduct(Object product) {
		this.products.add(product);
	}
}