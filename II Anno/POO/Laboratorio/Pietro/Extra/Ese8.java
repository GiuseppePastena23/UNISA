//Classe Employee con nome, salario e data d'assunzione
//Metodi per calcolare gli anni di servizio

import java.time.LocalDate;
//LocalDate è un oggetto immutabile che rappresenta una data in forma anno mese giorno
import java.time.Period;
//Modella una quantità di tempo in termini di anni, mesi e giorni
//Le unità supportate sono YEARS, MONTHS e DAYS.

class Employee {
	private String name;
	private double salary;
	private LocalDate hireDate;
	//Costruttore
	public Employee(String name, double salary, LocalDate hireDate) {
    	this.name = name;
    	this.salary = salary;
    	this.hireDate = hireDate;
	}
	//Get e Set
  	public String getName() {
    	return name;
	}
  	public void setName(String name) {
		this.name = name;
  	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	//Metodo per ottenere gli anni di servizio
	public int getYearsOfService() {
		return Period.between(hireDate, LocalDate.now()).getYears();
	}
	//between(LocalDate startDateInclusive, LocalDate endDateExclusive)
	//Serve ad ottenere un periodo composto da anni, mesi e giorni tra due date
	//getYears() ottiene la quantità di anni del periodo
	//now() ottiene la data attuale dall'orologio
	
	//Stampa delle informazioni
	public void printDetails() {
    	System.out.println("\nName: " + name);
    	System.out.println("Salary: " + salary);
    	System.out.println("HireDate: " + hireDate);
  }
}

public class Ese8 {
	public static void main(String[] args) {
		Employee e1 = new Employee ("Roberta Petrus", 50000, LocalDate.parse("2021-04-01"));
    	Employee e2 = new Employee ("Loyd Blair", 70000, LocalDate.parse("2015-04-01"));
    	Employee e3 = new Employee ("Magdalena Artemon", 50000, LocalDate.parse("2011-01-15"));
		//parse(CharSequence text) ottiene un istanza di LocalDate da una stringa in formato aaaa-mm-gg
		
    	e1.printDetails();
    	System.out.println ("Years of Service: " + e1.getYearsOfService());
    	e2.printDetails();
    	System.out.println ("Years of Service: " + e2.getYearsOfService());
    	e3.printDetails();
    	System.out.println ("Years of Service: " + e3.getYearsOfService());
  }
}