package com.exsnake;

import java.util.ArrayList;

/**
 * Train class
 * Used to represent a train his total seat
 */
public class Train {
    private int seats;
    private int traveledKm;
    private int costPerKm;
    private Restaurant restaurant;
    private ArrayList<RailwaySection> trainStops;

    //Constructor
    public Train(int seats, int traveledKm, int restaurantSeats, int costPerKm) {
        this.restaurant = new Restaurant(restaurantSeats);
        this.seats = seats;
        this.traveledKm = traveledKm;
        this.costPerKm = costPerKm;
    }

    //Getter and Setter
    public int getSeats() {
        return seats;
    }

    public int getTraveledKm() {
        return traveledKm;
    }

    public int getCostPerKm() {
        return costPerKm;
    }
    //End Getter and Setter

    //Methods

    /**
     * Ottiene il numero di fermate per questo treno
     * @return Total Stops Count
     */
    public int getStopsCount() {
        return this.trainStops.size();
    }

    /**
     * Ottiene il guadagno stimato per il treno sommando il totale dei
     * km per fermata
     * @return estimated profit
     */
    public double estimatedProfit() {
        double sum = 0;
        for (RailwaySection section :
                this.trainStops) {
            sum += section.getTraveledKm() * this.getCostPerKm();
        }
        return sum;
    }

    /**
     * Ottiene il guadagno stimato per il ristorante del treno in base
     * al numero totale dei posti disponibili e al prezzo medio stimato
     * @return estimated restaurant profit
     */
    public double estimatedRestaurantGain() {
        return 0;
    }

    /**
     * Aggiunge un percorso compiuto dal treno
     * Verifica che l'ultima stazione coincida con quella iniziale (?)
     * @param section RailwaySection
     * @return bool se tutto ok
     */
    public boolean addRailwaySection(RailwaySection section) {
        //check if it starts from the last section ending station ?
        this.trainStops.add(section);
        return true;
    }



}
