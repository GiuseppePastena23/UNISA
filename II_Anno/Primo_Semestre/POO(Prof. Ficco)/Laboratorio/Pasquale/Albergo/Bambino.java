package cliente;

public class Bambino extends Cliente {
    private int age;
    private final String nomeGenitore1, nomeGenitore2; // bruhhhhhhh

    public Bambino(String nome, String cognome, int age, String nomeGenitore1, String nomeGenitore2) {
        super(nome, cognome);
        this.age = age;
        this.nomeGenitore1 = nomeGenitore1;
        this.nomeGenitore2 = nomeGenitore2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNomeGenitore1() {
        return nomeGenitore1;
    }

    public String getNomeGenitore2() {
        return nomeGenitore2;
    }

    @Override
    public String toString() {
        return "Bambino{" +
                "age=" + age +
                ", nomeGenitore1='" + nomeGenitore1 + '\'' +
                ", nomeGenitore2='" + nomeGenitore2 + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
