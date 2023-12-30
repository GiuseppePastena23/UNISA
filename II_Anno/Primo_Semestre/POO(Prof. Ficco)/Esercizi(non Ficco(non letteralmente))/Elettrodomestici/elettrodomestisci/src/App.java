import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Domotica domotica = new Domotica();

        Lavastoviglie lavastovigliePhilips = new Lavastoviglie("Philips", "RS1000");
        lavastovigliePhilips.addProgrammaLavaggio("Standard");
        lavastovigliePhilips.addProgrammaLavaggio("Mezzocarico");
        lavastovigliePhilips.addProgrammaLavaggio("Prelavaggio");
        lavastovigliePhilips.addProgrammaLavaggio("Intensivo");
        domotica.aggiungiElettrodomestico(lavastovigliePhilips);

        Lavastoviglie lavastoviglieSamsung = new Lavastoviglie("Samsung", "QLava");
        lavastoviglieSamsung.addProgrammaLavaggio("Standard");
        lavastoviglieSamsung.addProgrammaLavaggio("Mezzocarico");
        lavastoviglieSamsung.addProgrammaLavaggio("Prelavaggio");
        lavastoviglieSamsung.addProgrammaLavaggio("Intensivo");
        domotica.aggiungiElettrodomestico(lavastoviglieSamsung);

        BluRayPlayer bluraySony = new BluRayPlayer("PS5", new ArrayList<String>(
                                            Arrays.asList("Matrix", 
                                                        "Matrix Reloaded", 
                                                        "Matrix Revolutions", 
                                                        "Il signore degli Anelli - La compagnia dell'anello", 
                                                        "Il signore degli anelli - Le due torri", 
                                                        "Il signore degli anelli - Il ritorno del re")
                                                        )
                                                    );
        domotica.aggiungiElettrodomestico(bluraySony);

        for (int i = 0; i < 10; i++) {
            System.out.print(domotica.testElettrodomestici());
        }
    }
}
