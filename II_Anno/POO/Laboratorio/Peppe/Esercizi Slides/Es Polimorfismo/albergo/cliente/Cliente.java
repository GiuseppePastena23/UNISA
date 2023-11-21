package albergo.cliente;

public abstract class Cliente {
    protected String name;
    protected String surname;

    protected Cliente(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public abstract void getClientInfo();
}
