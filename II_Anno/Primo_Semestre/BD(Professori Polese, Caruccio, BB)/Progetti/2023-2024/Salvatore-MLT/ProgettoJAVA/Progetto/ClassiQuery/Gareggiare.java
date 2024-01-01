package Progetto.ClassiQuery;

import java.time.LocalDate;

public class Gareggiare 
{

    private LocalDate dataGara;
    private String nomeSquadra;
    private int punteggio;
    private String squalifica;
    
            public Gareggiare(LocalDate dataGara, String nomeSquadra, int punteggio, String squalifica) {
                this.dataGara = dataGara;
                this.nomeSquadra = nomeSquadra;
                this.punteggio = punteggio;
                this.squalifica = squalifica;
            }
        
            public LocalDate getDataGara() {
                return dataGara;
            }
        
            public void setDataGara(LocalDate dataGara) {
                this.dataGara = dataGara;
            }
        
            public String getNomeSquadra() {
                return nomeSquadra;
            }
        
            public void setNomeSquadra(String nomeSquadra) {
                this.nomeSquadra = nomeSquadra;
            }
        
            public int getPunteggio() {
                return punteggio;
            }
        
            public void setPunteggio(int punteggio) {
                this.punteggio = punteggio;
            }
        
            public String getSqualifica() {
                return squalifica;
            }
        
            public void setSqualifica(String squalifica) {
                this.squalifica = squalifica;
            }
        
            @Override
            public String toString() {
                return "Gareggiare{" +
                        "dataGara=" + dataGara +
                        ", nomeSquadra='" + nomeSquadra + '\'' +
                        ", punteggio=" + punteggio +
                        ", squalifica='" + squalifica + '\'' +
                        '}';
            }
}    
