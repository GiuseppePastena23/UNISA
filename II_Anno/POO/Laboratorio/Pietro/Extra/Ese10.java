//Classe Airplane con numero di volo, destinazione e ora di decollo
//E metodi per controllare lo stato del volo e il ritardo

import java.time.LocalTime;

class Airplane {
	private String flightNumber;
	private String destination;
	private LocalTime scheduledDeparture;
	private int delayTime;
	//Costruttore
	public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.scheduledDeparture = scheduledDeparture;
		this.delayTime = 0;
	}
	//Set e Get
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalTime getScheduledDeparture() {
		return scheduledDeparture;
	}
	public void setScheduledDeparture(LocalTime scheduledDeparture) {
		this.scheduledDeparture = scheduledDeparture;
	}
	public int getDelayTime() {
		return delayTime;
	}
	public void delay(int minutes) {
		this.delayTime = minutes;
		this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
	}
	//Controllore
	public void checkStatus() {
		if (delayTime == 0) {
			System.out.println("Flight " + flightNumber + " is on time.");
		} else {
			System.out.println("Flight " + flightNumber + " is delayed by " + delayTime + " minutes.");
		}
	}
}

public class Ese10 {
	public static void main (String[] args) {
		Airplane f1 = new Airplane ("AAA", "London", LocalTime.of (10, 30));
		Airplane f2 = new Airplane ("BBB", "Paris", LocalTime.of (14, 0));
		Airplane f3 = new Airplane ("CCC", "Rome", LocalTime.of (14, 0));
		System.out.println ("Flight status:");
		f1.checkStatus();
		f2.checkStatus();
		f3.checkStatus();
		f1.delay (40);
		f2.delay (110);
		System.out.println ("Current flight status:");
		f1.checkStatus();
		f2.checkStatus();
		f3.checkStatus();
	}
}