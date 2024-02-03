import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci la dimensione della nuova lista");
        int dimensioneLista = scan.nextInt();
        MyList lista = new MyList(dimensioneLista);
        System.out.println("Lista[" + dimensioneLista + "] creata");

        boolean continua = true;
        while (continua) {
            printMenu();
            int scelta = scan.nextInt();
            switch (scelta) {
                case 1: {
                    System.out.println("inserisci l'elemento");
                    int el = scan.nextInt();
                    if (!lista.insert(el)) System.out.println("Operazione non riuscita");
                    break;
                }
                case 2: {
                    System.out.println("inserisci la posizione dell'elemento da cancellare");
                    int i = scan.nextInt();
                    if (!lista.delete(i)) System.out.println("Operazione non riuscita");
                    break;
                }
                case 3: {
                    System.out.println("inserisci la posizone dell'elemento da ottenere");
                    int i = scan.nextInt();
                    System.out.println("elemento ottenuto:" + lista.getElementByIndex(i));
                    break;
                }
                case 4: {
                    lista.printAll();
                    break;
                }

                default: {
                    continua = false;
                    break;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. inserisci elemento");
        System.out.println("2. cancella elemento data la sua posizione");
        System.out.println("3. ottieni l'elemento data la sua posizione");
        System.out.println("4. stampa l'intera lista");
        System.out.println("altro per uscire");
    }
}