package es1;

import java.util.Date;

public class Esame {
    public String nomeEsame;
    public int CFU;
    public int voto;
    public Date date;


    public Esame(String nomeEsame, int CFU, int voto, Date date) {
        this.nomeEsame = nomeEsame;
        this.CFU = CFU;
        this.voto = voto;
        this.date = date;
    }

    public String getNomeEsame() {
        return nomeEsame;
    }

    public void setNomeEsame(String nomeEsame) {
        this.nomeEsame = nomeEsame;
    }

    public boolean equals(Esame e) {
        return nomeEsame.equals(e.getNomeEsame());
    }

    @Override
    public String toString() {
        return "es1.Esame{" +
                "nomeEsame='" + nomeEsame + '\'' +
                ", CFU=" + CFU +
                ", voto=" + ((voto == 31)? "30L" : voto) +
                ", date=" + date +
                '}';
    }
}
