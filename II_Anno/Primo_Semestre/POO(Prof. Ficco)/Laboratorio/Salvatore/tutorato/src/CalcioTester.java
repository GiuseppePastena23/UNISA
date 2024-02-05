import core.*;
import java.util.List;
import java.util.ArrayList;

public class CalcioTester 
{
    public void tester()
    {
        Campionato campionato = new Campionato();
        Squadra esempio[] = new Squadra[5];
        Calciatori Cesempio[] = new Calciatori[5];
    
        for(int i = 0; i < 5; i++)
        {
            esempio[i].setNome("" + i);
            Cesempio[i].setNome("" + i);
            Cesempio[i].setCognome(" "+ i);
            Cesempio[i].setNumeroMaglia(i);
            esempio[i].setScudettiVinti(i);
            esempio[i].addCalciatore(Cesempio[i]); 
        }

        campionato.PrintCalciatoriByNumero(9);
        
    }

}
