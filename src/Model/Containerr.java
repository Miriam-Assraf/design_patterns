package Model;

import java.util.ArrayList;
import javafx.scene.paint.Color;

// we can change the generic "Object" to specific generic like <T extends something>
public class Containerr<T extends Object> extends Square {
	private static int idSerial = 0;
	private int id;
	private ArrayList<Object> products;
	private boolean mark;

	public Containerr() {
		super();
		setId(idSerial++);
		products = new ArrayList<Object>();
		setMark(false);
	}

	public Containerr(int x, int y, int width, int heigth) {
		this(x, y, RandomColor(), width, heigth);
	}

	public Containerr(int x, int y, Color color, int width, int heigth) {
		super(x, y, color, width, heigth);
		setId(idSerial++);
		products = new ArrayList<Object>();
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public ArrayList<Object> getProducts() {
		return products;
	}

	public void setProducts(Object products) {
		this.products.add(products);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Containerr)) {
			return false;
		}
		Containerr temp = (Containerr) obj;
		return id == temp.getId();
	}

	@Override
	public String toString() {
		return "The container id is: " + id + "\n The color container is: " + color.toString() + "\n";
	}
}
