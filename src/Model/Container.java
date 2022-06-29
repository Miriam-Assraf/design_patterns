package Model;

import java.util.ArrayList;

public class Container<T extends Object> implements Cloneable {
	private static int idSerial = 0;
	private int id;
	private ArrayList<Object> products;
	private ContainerState state;
	
	public Container() {
		this.id = idSerial++;
		this.products = new ArrayList<Object>();
		this.state = ContainerState.LOADED;
	}
	
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Object> getProducts() {
		return this.products;
	}
	
	public ContainerState getState() {
		return this.state;
	}
	
	public void setState(ContainerState state) {
		this.state = state;
	}
	
	public void addProduct(Object product) {
		this.products.add(product);
	}
	
	/* -----------------------------------Prototype------------------------------------- */
	@Override
	public Object clone() throws CloneNotSupportedException {
		Container copyContainer = new Container();
		copyContainer.id = this.id;
		copyContainer.products = (ArrayList) products.clone();
		
		return copyContainer;
	}
	/* --------------------------------------------------------------------------------- */
}