package core;

public class OreSuperateException extends RuntimeException {
    public OreSuperateException() {
        super("numero di ore dei corsi nella lista supera il numero di ore massimo previsto");
    }
}
