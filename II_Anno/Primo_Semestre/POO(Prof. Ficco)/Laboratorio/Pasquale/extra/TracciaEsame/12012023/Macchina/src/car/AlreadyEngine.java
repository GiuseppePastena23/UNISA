package car;

public class AlreadyEngine extends Exception {
    public AlreadyEngine(boolean isAccesa) {
        super("Il motore e' gia " + ((isAccesa) ? "acceso" : "spento"));
    }
}
