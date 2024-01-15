import campionato.*;
import campionato.exception.SquadraRegisteredException;

public class CalcioTester {
    static Campionato campionato = new Campionato("Serie A");
    public static void main(String[] args) {
        

        Squadra juventus = new Squadra("Juventus", 38);
        Squadra milan = new Squadra("Milan", 19);
        Squadra roma = new Squadra("Roma", 3);
        Squadra empoli = new Squadra("Empoli", 3);
        Squadra napoli = new Squadra("Napoli", 3);

        try
        {
            campionato.squadraSubscription(juventus);
            campionato.squadraSubscription(milan);
            campionato.squadraSubscription(roma);
            campionato.squadraSubscription(empoli);
            campionato.squadraSubscription(napoli);
        }catch(SquadraRegisteredException e){
            System.err.println(e);
        }

        campionato.addPlayer(new Giocatore("Ronaldo", 38, 7), juventus);
        campionato.addPlayer(new Giocatore("Pato", 34, 12), milan);
        campionato.addPlayer(new Giocatore("Totti", 47, 10),roma);
        campionato.addPlayer(new Giocatore("Caputo", 36, 9), empoli);
        campionato.addPlayer(new Giocatore("Higuain", 36, 9), napoli);

        campionato.printPlayersByNumber(9);
        campionato.printSquadreByScudetti();
        
        

    }
    
    

    
}
