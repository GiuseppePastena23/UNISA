import java.io.PrintStream;
import java.util.ArrayList;

public class BluRayPlayer implements Elettrodomestico {
    String nome;
    int inRiproduzione;
    ArrayList<String> films;

    @Override
    public void start() {
        if ( inRiproduzione == 0 )
            inRiproduzione = 1;
        next();
    }

    @Override
    public void next() {
        if ( films.size() == 0)
            return;

        if ( inRiproduzione >= films.size() )
            inRiproduzione = 1;
        else  
            inRiproduzione++;
    }

    public void load(ArrayList<String> films) {
        this.films = films;
    }

    public String getDetails(PrintStream stream) {
        //stream.println(stream);
    }

    public String getFilmInRiproduzione() {
        if (inRiproduzione == 0)
            return "BluRayPlayer is off";
        
        return films.get(inRiproduzione);
    }
    
}
