import java.util.ArrayList;



public class Contenitore <T> {
    ArrayList<T> list;

    public Contenitore(){
        list = new ArrayList<>();
    }

    public void add(T elem){
        list.add(elem);
    }

    public void remove(T elem)
    {
        list.remove(elem);
    }

    public void print()
    {
        for(T elem : list){
            System.out.println(elem);
        }
    }
}