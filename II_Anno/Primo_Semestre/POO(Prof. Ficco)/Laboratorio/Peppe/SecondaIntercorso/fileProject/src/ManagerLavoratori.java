import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.xml.crypto.Data;

public class ManagerLavoratori{
    
    List<Lavoratore> lavoratori;

    public ManagerLavoratori(){
        lavoratori = new ArrayList<>();
    }

    public void addLavoratore(Lavoratore l){
        lavoratori.add(l);
    }

    public void saveLavoratori(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(lavoratori);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stampaLavoratoriTerminale(){
        for(Lavoratore l : lavoratori){
            System.out.println(l.nome);
        }
    }

    public void readLavoratori(String filename){
        try(ObjectInputStream bf = new ObjectInputStream(new FileInputStream(filename))){
            lavoratori = (List<Lavoratore>) bf.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
}
