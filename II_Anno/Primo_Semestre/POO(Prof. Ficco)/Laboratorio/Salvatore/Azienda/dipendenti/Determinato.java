package dipendenti;

public class Determinato extends Dipendente
{
    private String DataFineContratto;

    Determinato(String nome, String cognome, String codFis, Float salario, String dataFineContratto)
    {
        super(nome, cognome, codFis, salario);
        this.DataFineContratto = dataFineContratto;
    }

    public String getDataFineContratto(){return (this.DataFineContratto);}
    public void setDataFineContratto(String dataFineContratto){this.DataFineContratto = dataFineContratto;}

    @Override
    public String toString()
    {
        return
        (
            "Nome = " + getNome() + "\n" +
            "Cognome = " + getCognome() + "\n" +
            "CodFis = " + getCodFis() + "\n" +
            "Salario = " + getSalario() + "\n" +
            "DataFineContratto = " + getDataFineContratto() + "\n"
        );
    }
}
