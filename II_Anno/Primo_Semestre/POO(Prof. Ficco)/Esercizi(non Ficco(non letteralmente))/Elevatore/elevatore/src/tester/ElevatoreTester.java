package tester;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import elevatore.Ascensore;
import elevatore.ElencoElevatori;
import elevatore.Elevatore;
import elevatore.ScalaMobile;
import elevatore.TipoSbagliatoException;

public class ElevatoreTester {
    public static void main(String[] args) {
        ElencoElevatori elevatori = new ElencoElevatori();
        elevatori.aggiungiElevatore(new Ascensore(1, "Stifler", 2000.00, 180.00));
        elevatori.aggiungiElevatore(new Ascensore(1, "SalieScendi", 3000.00, 200.00));
        elevatori.aggiungiElevatore(new Ascensore(1, "LaBilancia", 3000.00, 100.00));
        elevatori.aggiungiElevatore(new ScalaMobile(2, "LungaScala", 3500.00, 350));
        elevatori.aggiungiElevatore(new ScalaMobile(2, "VaVeloce", 5500.00, 90));
        elevatori.aggiungiElevatore(new ScalaMobile(2, "SaliAPiedi", 13750.00, 150));

        try {
            ArrayList<Elevatore> cercati = elevatori.cerca("Ascensore");
            System.out.println("Cercati:\n");
            for (Elevatore elevatore : cercati) {
                System.out.println(elevatore.toString());
            }
        } catch (TipoSbagliatoException e) {
            System.out.println("Errore");
            return;
        }

        System.out.println("Lista Elevatori:\n");
        System.out.println(elevatori.toString());

        try {
            URL path = ElevatoreTester.class.getResource("elevatori.txt");
            File myObj = new File(path.getFile());
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(String.format("%s", elevatori.toString()));
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
