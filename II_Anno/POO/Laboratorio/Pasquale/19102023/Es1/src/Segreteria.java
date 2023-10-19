public class Segreteria {
    String dipartimento;
    String numero;
    int n = 100;
    Studente[] studenti;
    private int indexStudenti = 0;

    public Segreteria(String dipartimento, String numero, int n) {
        this.dipartimento = dipartimento;
        this.numero = numero;
        this.n = n;
        studenti = new Studente[n];
    }

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Studente[] getStudenti() {
        return studenti;
    }

    public void setStudenti(Studente[] studenti) {
        this.studenti = studenti;
    }

    public void registraStudente(Studente studente) {
        studenti[indexStudenti] = studente;
        indexStudenti++;
    }

    public void removeStudente(int index) {
        for (int i = index; i < indexStudenti-1; i++) {
            studenti[i] = studenti[i+1];
        }
        indexStudenti--;
    }

    public String getStudent(int index) {
        return studenti[index].toString();
    }

    public void printAllStudent() {
        for (int i = 0; i < indexStudenti; i++) {
            System.out.println("INDEX #" + i + "\t" + studenti[i]);
        }
    }

}
