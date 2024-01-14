
public abstract class Moneta {
    protected int valore;

    protected Moneta(int valore)
    {
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }

    public void setValore(int valore)
    {
        this.valore = valore;
    }
}
