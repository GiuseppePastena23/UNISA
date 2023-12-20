import game.*;

public class Test {
    // Implementare una classe Test in cui creare una lista di Player contenente almeno 3  Lottatori ed almeno 3 Maghi.
    // Si provi a richiamare tutti i metodi di Player comprese le get per vedere i risultati degli scontri ecc, chiama tutte le funzioni anche se ci sono exception e si verifichi che il comportamento sia quello atteso.    

    public static void main(String[] args) {
        Player[] players = new Player[6];
        players[0] = new Lottatore();
        players[1] = new Lottatore();
        players[2] = new Lottatore();
        players[3] = new Mago();
        players[4] = new Mago();
        players[5] = new Mago();

        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i].getHp());
            System.out.println(players[i].getAttPoint());
            System.out.println(players[i].getDefPoint());
            System.out.println(players[i].getFrags());
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());
            System.out.println(players[i].attacco(players[i]));
            System.out.println(players[i].isAlive());

            try {
                players[i].attaccoAereo(players[i]);
            } catch (IllegalActionException e) {
                System.out.println(e.getMessage());
            }

            try {
                players[i].fusione(players[i]);
            } catch (IllegalActionException e) {
                System.out.println(e.getMessage());
            }

            players[i].potenziamento();
        }
    
    }
}