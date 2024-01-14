package core.corsi;

import java.util.ArrayList;
import java.util.List;

public class CorsoMagistrale extends Corso{
    List<String> indirizziDiStudio;
    


    public CorsoMagistrale(String nome, String docente, int hFrontali, List<String> indirizziDiStudio){
        super(nome, docente, hFrontali);
        this.indirizziDiStudio = new ArrayList<>(indirizziDiStudio);
    }

    public List<String> dammiIndrizziDiStudio(){
        return indirizziDiStudio;
    }

    public int dammiNumeroCFU(){
        return hFrontali / 8;
    }

    
}