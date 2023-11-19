import java.util.ArrayList;

public class Pair <T>{
    
    ArrayList <T> pairs;
    public Pair(T value1, T value2)
    {
        pairs = new ArrayList<>();
        pairs.add(value1);
        pairs.add(value2);
    }

    public ArrayList<T> getValues()
    {
        return this.pairs;
    }

    public void setValues(T value1, T value2)
    {                                                                                   
        this.pairs = new ArrayList<>();
        this.pairs.add(value1);
        this.pairs.add(value2);
    }
}
