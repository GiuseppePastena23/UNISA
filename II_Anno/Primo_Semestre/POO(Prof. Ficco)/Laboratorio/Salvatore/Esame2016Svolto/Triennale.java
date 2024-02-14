package core;

public class Triennale extends Corso
{
    private String LinguaCorso;

    public Triennale(String nome, String docente, String linguaCorso, int totaleOreLezioni)
    {
        super(nome, docente, totaleOreLezioni);
        LinguaCorso = linguaCorso;
    }

    public int DammiNumeroCFU()
    {
        return(getTotaleOreLezioni()/4);
    }

    public int CalcolaCosto()
    {
        return(LinguaCorso.equalsIgnoreCase("inglese") ? getTotaleOreLezioni()*100 : getTotaleOreLezioni()*50 );
    }

    public String getLinguaCorso() {
        return LinguaCorso;
    }

    public void setLinguaCorso(String linguaCorso) {
        LinguaCorso = linguaCorso;
    }

    @Override
    public String toString() {
        return "Dottorato [Nome=" + getNome() + ", Docente=" + getDocente() + ", TotaleOreLezioni=" + getTotaleOreLezioni() +
                ", LinguaCorso=" + LinguaCorso + "]";
    }
}
