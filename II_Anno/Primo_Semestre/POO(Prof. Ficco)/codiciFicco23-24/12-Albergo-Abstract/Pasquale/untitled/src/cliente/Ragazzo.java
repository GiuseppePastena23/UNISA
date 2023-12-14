package cliente;

public class Ragazzo extends Cliente {
    private final String id;

    public Ragazzo(String nome, String cognome, String id) {
        super(nome, cognome);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ragazzo{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
