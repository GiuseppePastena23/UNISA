import java.io.*;
import java.util.ArrayList;

public class ManagerLavoratore extends ArrayList<Lavoratore> implements FileManager {
    public void readLavoratori(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Lavoratore l = (Lavoratore) ois.readObject();
        } catch (IOException e) {
            System.err.println("huh?");
        } catch (ClassNotFoundException e) {
            System.err.println("HUH?!?!?!?");
        }
    }

    public void saveLavoratori(String filename) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(filename))) {
            pw.println(this);
            pw.flush();
        } catch (IOException e) {
            System.err.println("huh?");
        }
    }

    public void saveLavoratoriObject(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            oos.flush();
        } catch (IOException e) {
            System.err.println("huh?");
        }
    }
}
