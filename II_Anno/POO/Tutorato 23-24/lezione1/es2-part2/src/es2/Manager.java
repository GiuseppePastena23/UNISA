package es2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager implements FileManager {
    private final List<Dipendente> dipendenti;

    public Manager() {
        dipendenti = new ArrayList<>();
    }

    public Manager(Dipendente ...d) {
        dipendenti = Arrays.asList(d);
    }

    public void add(Dipendente d) {
        dipendenti.add(d);
    }

    public void remove(Dipendente d) {
        dipendenti.remove(d);
    }

    public void removeAt(int index) {
        dipendenti.remove(index);
    }

    public Dipendente getAt(int index) {
        return dipendenti.get(index);
    }

    public List<Stagista> getStagisti() { //? public List<Dipendente> getStagisti() ?
        List<Stagista> res = new ArrayList<>();
        for (Dipendente d : dipendenti) {
            if (d instanceof Stagista) {
                res.add((Stagista) d);
            }
        }
        return res;
    }

    public void readLavoratori(String filename) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(filename));
            while (true) {
                try {
                    Dipendente d = (Dipendente) ois.readObject();
                    dipendenti.add(d);
                } catch (EOFException e) {
                    break;
                }
            }
            ois.close();
        } catch (Exception e) {
            System.err.println("Impossibile leggere il file " + filename + "\n" + e);
        }
    }


    public void saveLavoratori(String filename) {
        PrintWriter pw;

        try {
            pw = new PrintWriter(new FileWriter(filename));
            for (Dipendente d : dipendenti) {
                pw.println(d);
            }

            pw.close();
        } catch (IOException e) {
            System.err.println("Impossibile scrivere sul file " + filename + "\n" + e);
        }
    }

    public void saveLavoratoriBinary(String filename) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filename));
            for (Dipendente d : dipendenti) {
                oos.writeObject(d);
            }
            oos.close();
        } catch (IOException e) {
            System.err.println("Impossibile scrivere sul file " + filename + "\n" + e);
        }
    }

    public void salarioMensileSup(float soglia) {
        for (Dipendente d : dipendenti) {
            if (d.getStipendioMensile() > soglia) {
                System.out.println(d);
            }
        }
    }

    public void showDipendenti() {
        for (Dipendente d : dipendenti) {
            System.out.println(d);
        }
    }

    public void clear() {
        dipendenti.clear();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "dipendenti=" + dipendenti +
                '}';
    }
}
