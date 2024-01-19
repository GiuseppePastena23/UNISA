public class Dipendente {
    String nome, cognome;
    private double pagaOraria;
    private int maxOre = 40;

    public Dipendente(String nome, String cognome, double pagaOraria) {
        this.nome = nome;
        this.cognome = cognome;
        this.pagaOraria = pagaOraria;
    }

    public double getPagaOraria() {
        return pagaOraria;
    }

    public int getMaxOre(){
        return maxOre;
    }

}
