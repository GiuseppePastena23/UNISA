import java.io.PrintStream;
import java.util.ArrayList;

public class BluRayPlayer implements Elettrodomestico {
    String nome;
    int inRiproduzione;
    ArrayList<String> films;

    public BluRayPlayer(String nome, ArrayList<String> films) {
        this.nome = nome;
        this.films = films;
        inRiproduzione = -1;
    }

    @Override
    public String start() {
        if ( films.size() == 0 )
            return "Nessun film";
        return next();
    }

    @Override
    public String next() {
        inRiproduzione++;
        if ( inRiproduzione >= films.size() - 1 ) {
            inRiproduzione = 0;
            return "In riproduzione: " + films.get(inRiproduzione);
        } 
        return "In riproduzione: " + films.get(inRiproduzione);
    }
    
}
