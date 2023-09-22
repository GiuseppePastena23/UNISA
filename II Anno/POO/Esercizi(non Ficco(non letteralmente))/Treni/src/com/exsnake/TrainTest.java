package com.exsnake;

class TrainTest {
    Train treno1;
    Train treno2;
    RailwaySection sanSeverinoBaronissi;
    RailwaySection baronissiNapoli;

    void setUp() {
        treno1 = new Train(100,12304,25,2);
        treno2 = new Train(65,35500,35, 3);
        Station baronissiStation = new Station("Baronissi Stazione", 110);
        Station mercatoSanSeverinoStation = new Station("Mercato San Severino Centrale", 132);
        Station napoliStation = new Station("Napoli Piazza Garibaldi", 213);
        sanSeverinoBaronissi = new RailwaySection(mercatoSanSeverinoStation, 10,05,
                                                                    baronissiStation,10, 35);
        baronissiNapoli = new RailwaySection(baronissiStation, 10,55,
                                                                napoliStation,12, 35);
        treno1.addRailwaySection(baronissiNapoli);
        treno2.addRailwaySection(sanSeverinoBaronissi);
        treno2.addRailwaySection(baronissiNapoli);
    }

    void tearDown() {
        assert treno1.getSeats() == 100;
        assert treno2.getSeats() == 95;
        assert sanSeverinoBaronissi.getTraveledKm() == 22;
        assert baronissiNapoli.getTraveledKm() == 103;
        assert treno1.estimatedProfit() == (baronissiNapoli.getTraveledKm() * treno1.getCostPerKm());
        assert treno2.estimatedProfit() == (sanSeverinoBaronissi.getTraveledKm() * treno2.getCostPerKm() +
                                                baronissiNapoli.getTraveledKm() * treno2.getCostPerKm());
    }
}