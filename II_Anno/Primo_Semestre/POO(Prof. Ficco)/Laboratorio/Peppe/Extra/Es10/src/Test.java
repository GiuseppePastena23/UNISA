import car.*;
import java.awt.Color;

public class Test {
    public static void main(String[] args) {
        try {
            // Test Macchina
            Macchina macchina = new Macchina("Sedan", 4, 2000, Color.BLUE, 123, "ABC123", 5);
            macchina.accendi();
            System.out.println("Macchina accesa");

            try {
                macchina.accendi(); // Tentativo di accendere un'auto già accesa
            } catch (CarAlreadyOnOff e) {
                System.err.println("Errore: " + e.getMessage());
            }

            macchina.spegni();
            System.out.println("Macchina spenta");

            try {
                macchina.spegni(); // Tentativo di spegnere un'auto già spenta
            } catch (CarAlreadyOnOff e) {
                System.err.println("Errore: " + e.getMessage());
            }

            // Test Camion
            Camion camion = new Camion("Truck", 8, 4000, Color.RED, 456, "XYZ789", 10, 15.5f, 5000, 80);
            camion.accendi();
            System.out.println("Camion acceso");

            try {
                camion.accendi(); // Tentativo di accendere un camion già acceso
            } catch (CarAlreadyOnOff e) {
                System.err.println("Errore: " + e.getMessage());
            }

            // Test caricamento/scaricamento rimorchio
            camion.caricaRimorchio(3000);
            System.out.println("Peso caricato nel rimorchio: " + camion.pesoCarico);

            camion.scaricaRimorchio();
            System.out.println("Rimorchio scaricato");

            camion.spegni();
            System.out.println("Camion spento");

            try {
                camion.spegni(); // Tentativo di spegnere un camion già spento
            } catch (CarAlreadyOnOff e) {
                System.err.println("Errore: " + e.getMessage());
            }
        } catch (CarAlreadyOnOff e) {
            System.err.println("Errore generico: " + e.getMessage());
        }
    }
}