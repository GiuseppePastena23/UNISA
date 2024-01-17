import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private ArrayList<Ufficio> listaUffici;

    public Manager(){
        listaUffici = new ArrayList<>();
    }

    public void aggiungiLavoratore(Ufficio x, Lavoratore y){
       try{
        x.addLavoratore(y);
        } catch(DipinpiuUfficiException ex){ex.printStackTrace();}
    }

    public void rimuoviLavoratore(Ufficio x, Lavoratore y){
        x.removeLavoratore(y);
    }

    public void salvaDirigentiinFileBinario(String path){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(listaUffici.stream().flatMap(s -> s.getListaimpiegati().stream().filter(l -> l instanceof Dirigente)).distinct().collect(Collectors.toList()));
        } catch(IOException ioe){ioe.printStackTrace();}
    }

    public void salvaUfficioinFileText(String path, String nome_ufficio){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            Optional<Ufficio> u = listaUffici.stream().filter(uff -> uff.getNome().equals(nome_ufficio)).findFirst();//Errore sulla findFirst: restituisce un Optional<Ufficio> invece che Ufficio, serve il .get().

            Ufficio uff;
            if (u.isPresent()) uff = u.get();
            else throw new IllegalArgumentException("Ufficio non trovato");

            List<Lavoratore> list = uff.getListaimpiegati().stream().filter(l -> l instanceof Dipendente).toList();
            for(Lavoratore x : list){
                writer.write(x.getNome() + " " + x.getCognome() + " "+ x.getCF()); //Errore, la traccia chiedeva tutti i dati.
                writer.newLine();
            }
        } catch(Exception e) {e.printStackTrace();}
    }

    // Me son scordato il resto della traccia:
    public double metodo_e(){
        long num = listaUffici.stream().flatMap(u -> u.getListaimpiegati().stream().filter(i -> i instanceof Dipendente && i.sesso == Sesso.FEMMINA)).count(); //Errore: ho impostato ad int invece che long;
        double stipendi = listaUffici.stream().flatMap(u -> u.getListaimpiegati().stream().filter(i -> i instanceof Dipendente && i.sesso == Sesso.FEMMINA)).mapToDouble(Lavoratore::getStipendio).sum(); //Si poteva fare direttamente con .average()   //Errore,non ho fatto la mapToInt.
        return stipendi/num;
    }






}
