package core.corsi;

public class CorsoDottorato extends Corso{
    private String lingua;


    public CorsoDottorato(String nome, String docente,int hLezione, String lingua){
        super(nome, docente, hLezione);
        this.lingua = lingua;
    }

    public int dammiNumeroCFU(){
        return hFrontali / 4;
    }

    @Override
    public int calcolaCosto(){
        if(lingua.equalsIgnoreCase("inglese")){
            return hFrontali * 100;
        }
        else {
            return super.calcolaCosto();
        }
    }
}