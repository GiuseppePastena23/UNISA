
import java.util.ArrayList;


public class Libreria {
    ArrayList<Libro> libri;

    public Libreria() {
        libri = new ArrayList<Libro>();
    }

    public ArrayList<Libro> getLibriByAutore(String autore) {
        ArrayList<Libro> list = new ArrayList<Libro>();
        for (Libro libro : this.libri) {
            if(libro.getAutore() == autore)
                list.add(libro);
        }
        return list;
    }

    public ArrayList<Libro> getLibriConPiuCopie(){
        int max = 0;
        ArrayList<Libro> list = new ArrayList<Libro>();
        for (Libro lib : libri) {
            if (lib.getNumCopie() > max) {
                max = lib.getNumCopie();
                list = new ArrayList<Libro>();
            } else if (lib.getNumCopie() == max) {
                list.add(lib);
            }
        }
        return list;
    }

    public ArrayList<Libro> getLibriInEsaurimento(int numMaxCopie) {
        ArrayList<Libro> list = new ArrayList<Libro>();
        for (Libro lib : libri) {
            if(lib.getNumCopie() < numMaxCopie)
                list.add(lib);
        }
        return list;
    }

    public boolean AggiungiLibro(Libro libro) {
        for (Libro lib : libri) {
            if (lib.equals(libro)) {
                lib.setNumCopie(lib.getNumCopie() + 1);
                return true;
            }
        }
        libri.add(libro);
        return true;
    }

    public boolean AggiungiLibroByTitolo(String titolo, int numCopie) {
        for (Libro lib : libri) {
            if (lib.getTitolo() == titolo){
                lib.setNumCopie(numCopie);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Libro> getLibriByTitolo(String testo) {
        ArrayList<Libro> list = new ArrayList<Libro>();
        for (Libro lib : libri) {
            if (lib.getTitolo().contains(testo)){
                list.add(lib);
            }
        }
        return list;
    }

    public ArrayList<Libro> getLibri(){
        return libri;
    }
}
