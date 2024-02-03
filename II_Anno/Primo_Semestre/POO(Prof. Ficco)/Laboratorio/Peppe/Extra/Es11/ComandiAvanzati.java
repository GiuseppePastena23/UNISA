package game;

public interface ComandiAvanzati {
    boolean fusione(Player two) throws IllegalActionException;
    void attaccoAereo(Player other) throws IllegalActionException;
}