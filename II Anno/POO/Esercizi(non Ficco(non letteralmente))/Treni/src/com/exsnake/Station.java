package com.exsnake;

public class Station {
    private String name;
    private int railwayKm;

    public Station(String nome, int railwayKm) {
        this.name = nome;
        this.railwayKm = railwayKm;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public int getRailwayKm() {
        return railwayKm;
    }

    public void setRailwayKm(int railwayKm) {
        this.railwayKm = railwayKm;
    }
}
