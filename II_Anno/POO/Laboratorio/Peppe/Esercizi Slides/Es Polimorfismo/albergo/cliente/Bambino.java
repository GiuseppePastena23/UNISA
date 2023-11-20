package albergo.cliente;

public class Bambino extends Cliente{
    
    private String nomePadre, nomeMadre;
    
    public Bambino(String name, String cognome, String nomePadre, String nomeMadre)
    {
        super(name, cognome);
        this.nomePadre = nomePadre;
        this.nomeMadre = nomeMadre;
    }


    public void getClientInfo(){
        System.out.println("Type: Adult" +
                            "\nName: " + this.name +
                            "\nSurname: " + this.surname +
                            "\nNomi genitori : " + this.nomePadre + " " + this.nomeMadre + "\n");
    }
}
