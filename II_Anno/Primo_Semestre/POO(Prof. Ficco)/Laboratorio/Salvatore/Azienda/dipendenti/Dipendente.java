package dipendenti;

public class Dipendente 
{
    private String Nome;
    private String Cognome;
    private String CodFis;
    private Float Salario;

    Dipendente(String nome, String cognome, String codFis, Float salario)
    {
        this.Nome = nome;
        this.Cognome = cognome;
        this.CodFis = codFis;
        this.Salario = salario;
    }

    public String getNome(){return (this.Nome);}
    public String getCognome(){return (this.Cognome);}
    public String getCodFis(){return (this.CodFis);}
    public Float getSalario(){return (this.Salario);}

    public void setNome(String nome){this.Nome = nome;}
    public void setCognome(String cognome){this.Cognome = cognome;}
    public void setCodFis(String codFis){this.CodFis = codFis;}
    public void setSalario(Float salario){this.Salario = salario;}

    @Override
    public String toString()
    {
        return
        (
            "Nome = " + getNome() + "\n" +
            "Cognome = " + getCognome() + "\n" +
            "CodFis = " + getCodFis() + "\n" +
            "Salario = " + getSalario() + "\n"
        );
    }


}
