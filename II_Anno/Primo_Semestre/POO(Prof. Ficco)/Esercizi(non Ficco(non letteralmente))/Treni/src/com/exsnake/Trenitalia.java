import java.util.ArrayList;

public class Trenitalia {
    private ArrayList<Train> trains;

    public void addTrain(Train train){
        trains.add(train);
    }

    public double getMaxRevenue(){
        for (Train train : trains) {
            train.getCostPerKm();
        }
    }

    public void addRoute(Station startStation, Station endStation){

    }

    public void addStation(String name, int km){

    }

}
