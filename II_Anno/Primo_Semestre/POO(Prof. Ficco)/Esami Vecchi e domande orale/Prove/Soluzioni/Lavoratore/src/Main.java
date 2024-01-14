import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ciao.txt"));
            ArrayList<Lavoratore> list = new ArrayList<>();
            list.add(new Lavoratore("Mario", "Rossi", 100.0f));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ciao.txt"));
            ArrayList<Lavoratore> list = (ArrayList<Lavoratore>) ois.readObject();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
