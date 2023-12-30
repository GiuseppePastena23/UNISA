package interfaces;
import core.MyLocale;

public interface LocaleOptions {
    public boolean prenota(MyLocale locale, int nPersone);
    public void printInfo();
    public void registraLocale(MyLocale newLocale);
}
