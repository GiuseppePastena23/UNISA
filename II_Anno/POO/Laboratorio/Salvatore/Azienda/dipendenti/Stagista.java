package dipendenti;

public class Stagista extends Dipendente
{
    private String Supervisore;

    Stagista(String nome, String cognome, String codFis, Float salario, String supervisore)
    {
        super(nome, cognome, codFis, salario);
        this.Supervisore = supervisore;
    }

    public String getSupervisore(){return(this.Supervisore);}
    public void setSupervisore(String supervisore){this.Supervisore = supervisore;}

    //metodo decremento 300 causa stagista
    public Float SalarioStagista()
    {
        return((super.getSalario()) - 300f);
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
            "Salario effettivo = " + SalarioStagista() + "\n" +
            "Supervisore = " + getSupervisore() + "\n"
        );
    }
}
