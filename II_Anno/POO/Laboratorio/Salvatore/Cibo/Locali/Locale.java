package Locali;

public class Locale
{
    private String Nome;
    private String Indirizzo;
    private int PostiDisponibili;

    Locale(String Nome, String Indirizzo, int PostiDisponibili)
    {
        this.Nome = Nome;
        this.Indirizzo = Indirizzo;
        this.PostiDisponibili = PostiDisponibili;
    }

    public String getNome(){return Nome;}
    public String getIndirizzo(){return Indirizzo;}
    public int getPostiDisponibili(){return PostiDisponibili;}

    public void setNome(String Nome){this.Nome = Nome;}
    public void setIndirizzo(String Indirizzo){this.Indirizzo = Indirizzo;}
    public void setPostiDisponibili(int PostiDisponibili){this.PostiDisponibili = PostiDisponibili;}
}