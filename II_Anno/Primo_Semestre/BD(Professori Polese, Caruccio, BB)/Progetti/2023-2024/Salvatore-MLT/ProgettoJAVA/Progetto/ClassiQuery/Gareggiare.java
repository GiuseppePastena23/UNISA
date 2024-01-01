package Progetto.ClassiQuery;

import java.sql.Date;

public class Gareggiare 
{

    private Date dataGara;
    private String nomeSquadra;
    private int punteggio;
    private String squalifica;
    
            public Gareggiare(Date dataGara, String nomeSquadra, int punteggio, String squalifica) {
                this.dataGara = dataGara;
                this.nomeSquadra = nomeSquadra;
                this.punteggio = punteggio;
                this.squalifica = squalifica;
            }
        
            public Date getDataGara() {
                return dataGara;
            }
        
            public void setDataGara(Date dataGara) {
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
