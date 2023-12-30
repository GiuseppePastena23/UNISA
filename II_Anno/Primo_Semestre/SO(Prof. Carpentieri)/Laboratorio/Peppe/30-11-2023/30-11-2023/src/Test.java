import officina.*;
import java.util.Scanner;
import java.io.*;

public class Test{
	public static void main(){
		Officina officina = new Officina("schede1.txt");
		officina.fromFile("schede.txt");
		officina.toFile();
		FileInputStream sorgente = new FileInputStream("in.dat");
		int numConsegne = sorgente.read();
		
	}
}
