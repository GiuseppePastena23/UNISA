package main.medicinali;
import java.io.*;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class MedSystem implements Serializable{

    ArrayList<Medicinale> medicinali;

    public MedSystem(){
        medicinali = new ArrayList<>();
    }

    public void addElement(Medicinale medicinale){
        medicinali.add(medicinale);
    }

    

    public void printScadutidaAzienda(String azienda){
        medicinali.stream()
                  .filter(m -> m.isScaduto() && m.getAzienda().equals(azienda))
                  .forEach(System.out::println);
    }

    public void printSperimentaliIntermedia(){
        medicinali.stream()
                  .filter(m -> (m instanceof Sperimentale) && ((Sperimentale)m).getStato().equals(StatoSperimentazione.INTERMEDIO))
                  .forEach(System.out::println);
    }

    public void printUnita(){
        List<Medicinale> listsorted = medicinali.stream().sorted((m1, m2) -> Integer.compare(m1.getDisp(), m2.getDisp())).collect(Collectors.toList());
        System.out.println(listsorted.get(0));
        System.out.println(listsorted.get(listsorted.size() - 1 ));
    }

    public void stampaOrdineAlfa(){
        medicinali.stream().sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).forEach(System.out::println);
    }

    public void stampaToFile(){
        try(PrintWriter oos = new PrintWriter("medicinali.txt")){
                for(Medicinale m : medicinali){
                    oos.println(m);
                }
                oos.close();
            }
            catch(Exception ex){
                System.out.println(ex);
            }
    }

    public void getFromFile(){
        
        try(BufferedReader br = new BufferedReader(new FileReader("medicinali.txt"))){
            String line;
             Medicinale medicinale;
            while((line = br.readLine()) != null){
                // Parse the line and create a Medicinale object
                medicinale = new Medicinale(line.split(",")[0], line.split(",")[1], line.split(",")[2], Integer.parseInt(line.split(",")[3]), Boolean.parseBoolean(line.split(",")[4]));
                medicinali.add(medicinale);
            }
        } catch(IOException ex){
            System.out.println(ex);
        }
        
    }
}