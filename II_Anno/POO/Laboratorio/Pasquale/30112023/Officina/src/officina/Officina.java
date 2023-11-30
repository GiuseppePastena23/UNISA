package officina;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Officina {
    public static int currentID = 0;

    private List<Scheda> schede;


    private final String fileBinario = "lefted.bin";
    private String fileTesto;


    /* garantire la possibilità di iniziare un file vuoto
    public Officina() {
        schede = new ArrayList<Scheda>();
    }
    */

    public Officina() {
        schede = new ArrayList<Scheda>();
        initialize();
    }

    public void initialize() {

    }

    public void terminate() {

    }


    public void showAll() {
        for (var a : schede) {
            System.out.println(a);
        }
    }

    public void showInRiparazione() {
        for (var a : schede) {
            if (a.getStatus() == Status.RIPARAZIONE) {
                System.out.println(a);
            }
        }
    }

    public void showRiparati() {
        for (var a : schede) {
            if (a.getStatus() == Status.RIPARATO) {
                System.out.println(a);
            }
        }
    }

    public void showConsegnati() {
        for (var a : schede) {
            if (a.getStatus() == Status.CONSEGNATO) {
                System.out.println(a);
            }
        }
    }

    public void caricaVeicoli(String filename) {
        FileInputStream file = null;
        ObjectInputStream is = null;
        try {
            file = new FileInputStream(filename);
            is = new ObjectInputStream(file);
            while (true) {
                is.readObject();

            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            System.err.println("Si e' verificato un errore durante la lettura di " + filename + ": " + e);
        }
        finally {
            is.close();
            file.close();
        }
    }

}
