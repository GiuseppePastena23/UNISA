import java.util.GregorianCalendar;

public class Prodotto implements Comparable<Prodotto> {
    private Long codice;
    private String descrizione;
    private String marca;
    private double prezzo;
    private int quantita;
    private boolean inOfferta;
    private GregorianCalendar scadenzaOfferta;
    private double scontoAttuale;

    public Prodotto(Long codice, String descrizione, String marca, double prezzo, int quantita) {
        this.setCodice(codice);
        this.setDescrizione(descrizione);
        this.setMarca(marca);
        this.setPrezzo(prezzo);
        this.setQuantita(quantita);
        this.inOfferta = false;
        this.scadenzaOfferta = null;
        this.scontoAttuale = 0;
    }

    // Getter Setter

    /**
     * Ottiene il prezzo attuale con eventuale sconto
     * @return
     */
    public double getPrezzo() {
        return this.prezzo - this.prezzo * this.scontoAttuale / 100;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getCodice() {
        return codice;
    }
    public void setCodice(Long codice) {
        this.codice = codice;
    }

    //Methods

    /**
     * Mette un prodotto in offerta modificandone il prezzo a partire dal prezzo base
     * @param p Percentuale offerta range 0-100
     * @param g Data scadenza offerta, deve essere maggiore della data odierna
     * @return
     */
    public boolean mettiInOfferta(double p, GregorianCalendar g) {
        if( p < 0 || p > 100 || g.compareTo(new GregorianCalendar()) > 0 )
            return false;
        this.inOfferta = true;
        this.scadenzaOfferta = g;
        this.scontoAttuale = p;
        return true;
    }
    
    public void controllaOfferta() {
        if(!this.inOfferta) return;
        GregorianCalendar now = new GregorianCalendar();
        if (now.compareTo(this.scadenzaOfferta) > 0 ) {
            this.inOfferta = false;
            this.scontoAttuale = 0;
        }
    }

    @Override
    public String toString() {
        return inOfferta ? 
            String.format("Codice: %d\nMarca: %s\nDescrizione: %s\nIn Offerta con lo sconto del:%.0f%\nPrezzo: %.2f\nQuantita: %d", 
                 this.codice, this.marca, this.descrizione, this.scontoAttuale, this.getPrezzo(), this.quantita)
            :
            String.format("Codice: %d\nMarca: %s\nDescrizione: %s\nPrezzo: %.2f\nQuantita: %d", 
                this.codice, this.marca, this.descrizione, this.getPrezzo(), this.quantita);
    }

    @Override
    public boolean equals(Object o) {
        // Se e' lo stesso oggetto ritorna true
        if (o == this) {
            return true;
        }
        /*
         * Se e' un istanza di Prodotto o non "null instanceof [type]" returns false
         */
        if (!(o instanceof Prodotto)) {
            return false;
        }
        // typecast a Prodotto in modo da poter comparare gli id
        Prodotto c = (Prodotto) o;
        return codice == c.codice;
    }

    @Override
    public int compareTo(Prodotto o) {
        return this.getCodice().compareTo(o.getCodice());
    }

}
