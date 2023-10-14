//Crea una classe Employee con name, job title e salary
//Implementa metodi per calcolare ed aggiornare il salario

class Employee {
	private String name;
	private String jobTitle;
	private double salary;
	
	public Employee (String name, String jobTitle, double salary) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle (String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary (double salary) {
		this.salary = salary;
	}
	
	public void raiseSalary (double percentage) {
		salary = salary + ((salary * percentage) / 100);
	}
	
	public void printDetails() {
		System.out.println ("Name: " + name);
		System.out.println ("Job Title: " + jobTitle);
		System.out.println ("Salary: " + salary);
	}
}

public class Ese5 {
	public static void main (String[] args) {
		Employee e1 = new Employee ("Franz", "Manager", 30000);
		Employee e2 = new Employee ("Aaron", "Developer", 20000);
		
		System.out.println ("\nEmployee Details:");
		e1.printDetails();
		e2.printDetails();
		
		e1.raiseSalary (10);
		e2.raiseSalary (15);
		
		System.out.println ("\nAfter raising salary:");
		System.out.println ("\n10% per 'Franz':");
		e1.printDetails();
		System.out.println ("\n15% per 'Aaron':");
		e2.printDetails();
	}
}