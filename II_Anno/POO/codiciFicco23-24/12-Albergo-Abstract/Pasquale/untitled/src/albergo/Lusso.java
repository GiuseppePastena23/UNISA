package albergo;

public class Lusso extends Camera {
    protected boolean tv = false;

    public Lusso(int numero, float prezzo) {
        super(numero, prezzo);
    }

    public void accendiTV() {
        tv = true;
    }

    public void spegniTV() {
        tv = false;
    }

}
