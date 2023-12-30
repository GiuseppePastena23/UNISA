package albergo;

public class ExtraLusso extends Lusso {
    protected boolean condizionatore = false;

    public ExtraLusso(int numero, float prezzo) {
        super(numero, prezzo);
    }

    public void accendiCondizionatore() {
        condizionatore = true;
    }

    public void spegniCondizionatore() {
        condizionatore = false;
    }

}
