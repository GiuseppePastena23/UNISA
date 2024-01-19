package it.unisa.test;

public class ContatoreSincronizzato {
	
	
	public synchronized void contatore(String name) {
		if(name == "rebecca")
			notify();
		for (int i = 0; i < 199	; i++) {
			System.out.println(String.format("thread:%s %d%n", name, i));
			if(i == 100) {		
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
