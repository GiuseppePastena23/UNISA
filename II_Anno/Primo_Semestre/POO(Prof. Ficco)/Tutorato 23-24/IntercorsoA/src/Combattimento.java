import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combattimento {
    private List<Mostro> mostri;

    public Combattimento() {
        mostri = new ArrayList<Mostro>();
    }

    public void aggiungiMostro(Mostro nuovo) {
        mostri.add(nuovo);
    }

    public void combatti(int i, int j) {
        Mostro a = mostri.get(i);
        Mostro b = mostri.get(j);
        a.attack(b);
    }

    public void rimuovi() {
        for (int i = 0; i < mostri.size(); i++) {
            Mostro m = mostri.get(i);
            if (!m.isAlive()) {
                mostri.remove(i);
                i--;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Mostro m : mostri) {
            if (m.isAlive()) {
                string.append(m);
            }
        }
        return string.toString();
    }
}
