package albergo.cliente;

public class Adulto extends Cliente {

    private String cf;
    
    public Adulto(String name, String cognome, String cf)
    {
        super(name, cognome);
        this.cf = cf;
    }

    public void getClientInfo(){
        System.out.println("Type: Adult" +
                            "\nName: " + this.name +
                            "\nSurname: " + this.surname +
                            "\nCF : " + this.cf + "\n"
                            );
    }
}
