package com.exsnake;

/**
 * Indica la tratta ferroviaria
 * Contiene due stazioni, una di partenza e una di arrivo
 */
public class RailwaySection {
    private Station startStation;
    private int startHr;
    private int startMm;
    private Station endStation;
    private int endHr;
    private int endMm;

    //Costruttore
    public RailwaySection(Station start, int startHr, int startMm, Station end, int endHr, int endMm) {
        this.startStation = start;
        this.setStartHr(startHr);
        this.setStartMm(startMm);
        this.endStation = end;
        this.setEndHr(endHr);
        this.setEndMm(endMm);
    }
    //Getter and Setter
    public void setStartHr(int startHr) {
        this.startHr = startHr;
    }

    public void setStartMm(int startMm) {
        this.startMm = startMm;
    }

    public void setEndHr(int endHr) { ;
        this.endHr = endHr;
    }

    public void setEndMm(int endMm) {
        this.endMm = endMm;
    }
    //End Getter ad Setter

    //Metodi

    /**
     * Ottiene i km percorsi in questa tratta
     * @return kmPercorsi
     */
    public int getTraveledKm() {
        return Math.abs(this.endStation.getRailwayKm() - this.startStation.getRailwayKm());
    }
}
