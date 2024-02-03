package albergo;
import cliente.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Camera {
    protected final int numero;
    protected float prezzo;
    protected Stato stato = Stato.LIBERA;
    protected List<Cliente> ospiti = new ArrayList<>();


    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    public int getNumero() {
        return numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    // USAMI PER RIEMPIRE DI CLIENTI UNA STANZA
    public void riempiCamera(Cliente...clienti) {
        setStato(Stato.OCCUPATA);
        ospiti = Arrays.asList(clienti);
    }

    public void svuotaCamera() {
        ospiti.clear();
        setStato(Stato.LIBERA);
    }

    public void accendiLuce() {
        setStato(Stato.LUCE_ACCESA);
    }

    public void spegniLuce() {
        setStato(Stato.OCCUPATA);
    }

    public void pulisci() {
        System.out.println("Sto pulendo la stanza " + numero);
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "numero=" + numero +
                ", prezzo=" + prezzo +
                ", stato=" + stato +
                ", ospiti=" + ospiti +
                '}';
    }
}

