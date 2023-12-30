import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        //Caricamento Libreria
        Libreria libreria = CaricaLibreria(libreria, "Libreria/libreria/src/main/java/libreria/libreria.txt");
        //End

        //Test
        for (Libro lib : libreria.getLibriByTitolo("Basi")) {
            System.out.println(lib.toString());
        }
        System.out.println("Expected: Basi di dati - Paolo Atzeni Editore3");
        libreria.AggiungiLibroByTitolo("Basi di dati", 40);
        for (Libro lib : libreria.getLibriInEsaurimento(15)) {
            System.out.println(lib.toString());
        }
        System.out.println("Expected: Fai bei sogni - Gremellini Massimo Longanesi");

        //Aggiorna Libreria
        ScaricaLibreria(Libreria liberia, String nomeFile)
        //Endi
    }

    public static Libreria CaricaLibreria(String nomeFile) {
        Libreria libreria = new Libreria();
        try {
            File myObj = new File(nomeFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] result = data.split(";");
                Libro lib = new Libro(result[0], result[1], result[2], Integer.parseInt(result[3]));
                libreria.AggiungiLibro(lib);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return libreria;
    }

    public static boolean ScaricaLibreria(Libreria libreria, String nomeFile) {
        File myObj = new File(nomeFile);
        FileWriter myWriter;
        try {
            myWriter = new FileWriter(myObj);
            for (Libro libro : libreria.getLibri()) {
                myWriter.write(
                        libro.getTitolo() + ";" + 
                        libro.getAutore() + ";" + 
                        libro.getEditore() + ";" + 
                        libro.getNumCopie()
                    );
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
