import java.util.ArrayList;

public class Collezione {
    
    ArrayList<Moneta> monete;

    public Collezione(){
        monete = new ArrayList<>();
    }

    public void addOrRemove(Moneta m){
        if(!monete.remove(m)){
            monete.add(m);
        }
    }

    public void 

}
