package cliente;

public class Adulto extends Cliente {
    private final String id;

    public Adulto(String nome, String cognome, String id) {
        super(nome, cognome);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Adulto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
