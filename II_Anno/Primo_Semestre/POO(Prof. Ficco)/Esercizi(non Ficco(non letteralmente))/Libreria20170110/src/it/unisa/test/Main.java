package it.unisa.test;

import java.util.Iterator;

public class Main implements Runnable{
	Thread t; 
	ContatoreSincronizzato c;
	public Main(String name, ContatoreSincronizzato c) {
		this.c = c;
		t = new Thread(this,name);
		t.start();
	}

	public static void main(String[] args) {
		ContatoreSincronizzato c = new ContatoreSincronizzato();

		System.out.println("Thread padre: " + Thread.currentThread());
		Main thread1 = new Main("ciccio", c);
		Main thread2 = new Main("pippo", c);
		Main thread3 = new Main("rebecca", c);
	}

	@Override
	public void run() {
		c.contatore(this.t.getName());
	}


}
