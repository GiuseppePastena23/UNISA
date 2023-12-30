package elevatore;

import java.util.ArrayList;

public class ElencoElevatori {
    ArrayList<Elevatore> elevatori;

    public ElencoElevatori() {
        elevatori = new ArrayList<Elevatore>();
    }
    
    public void aggiungiElevatore(Elevatore e) {
        this.elevatori.add(e);
    }

    public String daiTipoElevatore(int i) {
        if(i < 0 || i >= this.elevatori.size()) 
            return null;
        return this.elevatori.get(i).getClass().getSimpleName();
    } 

    public boolean usaElevatore(int i) {
        Elevatore elev = this.elevatori.get(i);
        if(elev != null && elev instanceof Ascensore){
            Ascensore asc = (Ascensore) elev;
            asc.utilizza(asc.getPesoMax() - 1);
            return true;
        }
        return false;
    }

    public Elevatore getMinimo() {
        Elevatore min = elevatori.get(0);
        for (int i = 1; i < elevatori.size(); i++) {
            Elevatore e = elevatori.get(i);
            if(e.getCosto() < min.getCosto()){
                min = e;
            }
        }
        return min;
    }

    public ArrayList<Elevatore> cerca(String tipo) throws TipoSbagliatoException {
        tipo = tipo.toUpperCase();
        if(!tipo.equals("ASCENSORE") && !tipo.equals("SCALA MOBILE") && !tipo.equals("SCALAMOBILE"))
            throw new TipoSbagliatoException();

        ArrayList<Elevatore> tipiElevatori = new ArrayList<Elevatore>();
        for (Elevatore el : elevatori) {
            if(el.getClass().getSimpleName().toUpperCase().equals(tipo)){
                tipiElevatori.add(el);
            }
        }
        return tipiElevatori;
    }

    @Override
    public String toString() {
        String output = String.format("Elevatori presenti %d:\n", this.elevatori.size());
        for (Elevatore elevatore : this.elevatori) {
            output += String.format("%s\n", elevatore.toString());
        }
        return output;
    }
}
