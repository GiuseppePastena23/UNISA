public abstract class Prodotto {
    protected Certificato certificato;
    protected String name;
    protected double weight;

    // costruttore
    protected Prodotto(String name, double weight, Certificato certificato){
        this.name = name;
        this.weight = weight;
        this.certificato = certificato;
    }

    public String getName(){
        return this.name;
    }

    public double getWeight(){
        return this.weight;
    }

    public Certificato getCertificato(){
        return this.certificato;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setCertificato(Certificato certificato){
        this.certificato = certificato;
    }
}
