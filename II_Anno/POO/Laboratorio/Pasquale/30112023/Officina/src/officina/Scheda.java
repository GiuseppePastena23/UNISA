package officina;

import java.io.Serializable;
import java.util.Date;

public class Scheda implements Serializable {

    private final int id;
    private final String targa, modello;
    private Status status;
    private Date arrivo;

    public Scheda(String targa, String modello, Date arrivo) {
        id = ++Officina.currentID;
        this.targa = targa;
        this.modello = modello;
        this.arrivo = arrivo;
        if (arrivo.after(new Date())) { // se la data di arrivo è nel futuro
            status = Status.ATTESA;     // si attende l'arrivo in officina
        }
        else {
            status = Status.RIPARAZIONE;
        }
    }

    // forzatura
    public Scheda(String targa, String modello, Status status, Date arrivo) {
        id = ++Officina.currentID;
        this.targa = targa;
        this.modello = modello;
        this.status = status;
        this.arrivo = arrivo;
    }

    public int getId() {
        return id;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getArrivo() {
        return arrivo;
    }

    public void setArrivo(Date arrivo) {
        this.arrivo = arrivo;
    }

    @Override
    public String toString() {
        return "Scheda{" +
                "id=" + id +
                ", targa='" + targa + '\'' +
                ", modello='" + modello + '\'' +
                ", status=" + status +
                ", arrivo=" + arrivo +
                '}';
    }
}
