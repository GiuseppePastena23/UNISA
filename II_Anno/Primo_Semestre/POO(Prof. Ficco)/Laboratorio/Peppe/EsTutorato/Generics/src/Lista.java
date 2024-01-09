import java.util.ArrayList;

public class Lista<T> {

    ArrayList<T> list;

    public Lista(){
        list = new ArrayList<>();
    }

    public void addOnTop(T elem){
        list.add(0, elem);
    }   
    
    public void append(T elem){
        list.add(elem);
    }

    public void removeOnTop(){
        list.remove(0);
    }

    public void removeFromTail(){
        list.remove(list.size() - 1);
    }

    public void printAllElements(){
        for( T elem : list){
            System.out.println(elem.toString());
        }
    }

    public int returnSize(){
        return list.size();
    }

    

}