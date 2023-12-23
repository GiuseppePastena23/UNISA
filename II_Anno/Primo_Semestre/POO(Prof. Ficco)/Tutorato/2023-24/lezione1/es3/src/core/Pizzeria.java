package core;

import java.util.HashMap;
import java.util.Scanner;

public class Pizzeria extends MyLocale {
    public HashMap<String, Float> menu;

    public Pizzeria(String nome, String indirizzo, int postiDisponibili, HashMap<String, Float> menu) {
        super(nome, indirizzo, postiDisponibili);
        // FIXME
        this.menu = menu;
    }

    public HashMap<String, Float> getMenu() {
        return menu;
    }

    public void setMenu(HashMap<String, Float> menu) {
        this.menu = menu;
    }

    public static HashMap<String, Float> createMenu() {
        HashMap<String, Float> nuovoMenu = new HashMap<String, Float>();
        boolean continuare = true;
        String nome;
        float prezzo;
        Scanner scan = new Scanner(System.in);

        while (continuare) {
            System.out.println("Inserire una nuova pizza? (y/n)");
            continuare = scan.nextLine().charAt(0) == 'y';
            if (!continuare) break;

            System.out.println("Inserire il nome:");
            nome = scan.nextLine();
            System.out.println("Inserire il prezzo:");
            prezzo = scan.nextFloat();
            scan.nextLine(); // drop the \n

            nuovoMenu.put(nome, prezzo);
        }

        scan.close();
        return nuovoMenu;
    }


}
