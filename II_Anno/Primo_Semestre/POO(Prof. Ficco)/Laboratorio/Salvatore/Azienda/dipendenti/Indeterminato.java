package dipendenti;

public class Indeterminato  extends Dipendente
{
    private String QualificaSettoriale;

    Indeterminato(String Nome, String Cognome, String CodFis, Float Salario, String QualificaSettoriale)
    {
        super(Nome, Cognome, CodFis, Salario);
        this.QualificaSettoriale = QualificaSettoriale;
    }

    public String getQualificaSettoriale(){return (this.QualificaSettoriale);}
    public void setQualificaSettoriale(String QualificaSettoriale){this.QualificaSettoriale = QualificaSettoriale;}

    //metodo incremento salario 30% (bonus 30%)
    public Float SalarioIndeterminato()
    {
        return((super.getSalario())*1.3f);
    }

    @Override
    public String toString()
    {
        return
        (
            "Nome = " + getNome() + "\n" +
            "Cognome = " + getCognome() + "\n" +
            "CodFis = " + getCodFis() + "\n" +
            "Salario = " + getSalario() + "\n" +
            "Salario effettivo = " + SalarioIndeterminato() + "\n" +
            "Qualifica = " + getQualificaSettoriale() + "\n"
        );
    }

}
