//class Inventory with a collection of products
//and methods to add and remove products, and to check for low inventory

import java.util.ArrayList;

class Product {
	private String name;
	private int quantity;
	//Costruttore
	public Product (String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	//Metodi get e set
	public String getName() {
		return name;
	}
	public void setName (String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity (int quantity) {
		this.quantity = quantity;
	}
}

class Inventory {
	private ArrayList < Product > products;
	//Costruttore
	public Inventory () {
		products = new ArrayList < Product > ();
	}
	//Agginta e rimozione
	public void addProduct (Product p) {
		products.add (p);
	}
	public void removeProduct (Product p) {
		products.remove (p);
	}
	//Controllo inventario
	public void checkInventory() {
		for(Product product: products) {
			if (product.getQuantity() <= 50) {
				System.out.println (product.getName() + " is running low");
				System.out.println ("Quantity: " + product.getQuantity());
			}
		}
	}
}

public class Ese11 {
	public static void main (String[] args) {
		Inventory inventory = new Inventory();
		Product product1 = new Product("LED TV", 200);
		Product product2 = new Product("Mobile", 80);
		Product product3 = new Product("Tablet", 40);
		System.out.println("Add three products in inventory:");
		inventory.addProduct(product1);
		inventory.addProduct(product2);
		inventory.addProduct(product3);
		System.out.println("\nCheck low inventory:");
		inventory.checkInventory();
		System.out.println("\nRemove Tablet from the inventory!");
		inventory.removeProduct(product3);
		System.out.println("\nAgain check low inventory:"); 
		inventory.checkInventory();
	}
}