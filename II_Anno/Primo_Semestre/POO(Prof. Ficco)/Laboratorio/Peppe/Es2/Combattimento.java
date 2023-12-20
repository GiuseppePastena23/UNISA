import java.util.ArrayList;

public class Combattimento {
    
    protected ArrayList<Mostro> mostri;
    

    public Combattimento(){
        mostri = new ArrayList<>();
    }

    public void aggiungiMostro(Mostro mostro){
        mostri.add(mostro);
    }

    public void combatti(int i,int j){
        mostri.get(i).attacca(mostri.get(j));
    }

    public int rimuovi(){
        int res = 0;
        for(Mostro m : mostri){
            if(m.getHp() == 0){
                mostri.remove(m);
                res++;
            }
        }
        return res;
    }

    public String toString(){
        String res = "";
        for(Mostro m : mostri){
            if(m.getHp() > 0)
            {
                res = res.concat(m.toString());
            }
        }

        return res;
    }
}
