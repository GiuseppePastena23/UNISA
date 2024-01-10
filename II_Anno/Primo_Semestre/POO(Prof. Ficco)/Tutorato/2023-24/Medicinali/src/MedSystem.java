import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MedSystem {
    private final List<Medicinale> listaMedicinali;

    public MedSystem() {
        listaMedicinali = new ArrayList<>();
    }

    public void add(Medicinale m) {
        listaMedicinali.add(m);
    }

    public void remove(Medicinale m) {
        listaMedicinali.remove(m);
    }

    public void remove(int index) {
        listaMedicinali.remove(index);
    }

    public void stampaCondizione(Predicate<Medicinale> condizione) {
        listaMedicinali.stream()
                .filter(condizione)
                .forEach(System.out::println);
    }

    public void contaIntermedi() {
        System.out.println(
            listaMedicinali.stream()
                    .filter(m -> m instanceof Sperimentale && ((Sperimentale) m).getStato() == StatoSperimentazione.INTERMEDIO)
                    .count()
        );
    }

    public void maxUnita(Comparator<Medicinale> comp) {
        System.out.println(listaMedicinali.stream()
                .max(comp));
    }

    public void minUnita(Comparator<Medicinale> comp) {
        System.out.println(listaMedicinali.stream()
                .min(comp));
    }

    public void stampaOrdinata() {
        listaMedicinali.stream()
                .sorted((med1, med2) -> med1.getNome().compareToIgnoreCase(med2.getNome()))
                .forEach(System.out::println);
    }


    /*
    public static int stringValue(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value += s.charAt(i);
        }
        return value;
    }

     */
}
