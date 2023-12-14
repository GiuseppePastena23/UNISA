import java.io.*;

public class OfficinaTester {
	public static void main(String[] args) {
		Officina f = new Officina();
		
		
		SchedaAuto s1 = new SchedaAuto("AA257AA", "Ford", "In riparazione");
		SchedaAuto s2 = new SchedaAuto("AA257BB", "Peugeot", "In riparazione");
		SchedaAuto s3 = new SchedaAuto("CC257AA", "Ford", "In riparazione");
		f.aggiungiScheda(s1);
		f.aggiungiScheda(s2);
		f.aggiungiScheda(s3);
		f.veicoliAttuali();
		f.veicoliTotali();
		
		try {
			FileWriter myWriter = new FileWriter("filename.txt");

			System.out.println("Scrittura avvenuta con successo");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}