package ch18.sec10;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2093895522785110099L;

	//private static final long serialVersionUID=1;
	private int price;
	
	private String name;
	
	public Product(String name, int price) {
		this.price= price;
		this.name=name;
	}
	
	@Override
	public String toString() {return price+" : "+name;}
}
