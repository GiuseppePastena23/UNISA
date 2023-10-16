//Classe Student con nome, anno di corso e corsi
//E metodi per aggiungere e rimuovere corsi

import java.util.ArrayList;

class Student {
	private String name;
	private int grade;
	private ArrayList < String > courses;
	//Costruttore
	public Student (String name, int grade) {
		this.name = name;
		this.grade = grade;
		this.courses = new ArrayList < String > ();
	}
	//Metodi get
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public ArrayList < String > getCourses() {
		return courses;
	}
	//Aggiunta e rimozione corsi
	public void addCourse (String course) {
		courses.add (course);
	}
	public void removeCourse (String course) {
		courses.remove (course);
	}
	//Stampa informazioni
	public void printDetails() {
		System.out.println ("Name: " + name);
		System.out.println ("Grade: " + grade);
	}
}

public class Ese9 {
	public static void main (String[] args) {
		Student student1 = new Student("Carolus Vitali", 11);
		Student student2 = new Student("Nakeisha Uhuru", 10);
		Student student3 = new Student("Gabriella Cherice", 10);
		System.out.println("Student Details:");
		student1.printDetails();
		student2.printDetails();
		student3.printDetails();
		System.out.println("Adding courses for " + student1.getName());
		student1.addCourse("Math");
		student1.addCourse("Science");
		student1.addCourse("English");

		System.out.println(student1.getName() + "'s courses: " + student1.getCourses());

		System.out.println("\nAdding courses for " + student2.getName());
		student2.addCourse("History");
		student2.addCourse("Geography");
		student2.addCourse("English");
		System.out.println(student2.getName() + "'s courses: " + student2.getCourses());
		System.out.println("\nRemoving 'Science' course for " + student1.getName());
		student1.removeCourse("Science");
		System.out.println(student1.getName() + "'s courses: " + student1.getCourses());
  	}
}