package Progetto.ClassiQuery;

public class Circuito
{
    private String ID;
    private String Nome;
    private String Paese;

    public Circuito(String id, String nome, String paese) 
    {
        ID = id;
        Nome = nome;
        Paese = paese;
    }

    public String getId() 
    {
        return ID;
    }

    public void setId(String id) 
    {
        ID = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getPaese() {
        return Paese;
    }

    public void setPaese(String paese) {
        Paese = paese;
    }

    @Override
    public String toString() {
        return "Circuito{" +
                "id='" + ID + '\'' +
                ", nome='" + Nome + '\'' +
                ", paese='" + Paese + '\'' +
                '}';
    }
}
