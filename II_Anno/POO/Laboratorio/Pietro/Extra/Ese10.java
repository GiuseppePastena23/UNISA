//Classe Airplane con numero di volo, destinazione e ora di decollo
//E metodi per controllare lo stato del volo e il ritardo

import java.time.LocalTime;

public class Airplane {
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