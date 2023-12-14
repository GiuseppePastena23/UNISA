package core;
import interfaces.LocaleOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LocaliManager implements LocaleOptions {
    List<MyLocale> locali;

    public LocaliManager() {
        this.locali = new ArrayList<>();
    }

    public LocaliManager(List<MyLocale> locali) {
        this.locali = locali;
    }

    public List<MyLocale> getLocali() {
        return locali;
    }

    public void setLocali(List<MyLocale> locali) {
        this.locali = locali;
    }


    @Override
    public boolean prenota(MyLocale locale, int nPersone) {
        boolean canBook = false;
        if (!locali.contains(locale)) return canBook;

        if (locale instanceof Pizzeria) {
            if (locale.postiDisponibili >= nPersone) {
                locale.postiDisponibili -= nPersone;
                canBook = true;
            }
        }
        else if (locale instanceof Paninoteca) {
            if (locale.postiDisponibili >= nPersone && ((Paninoteca) locale).panini >= nPersone) {
                locale.postiDisponibili -= nPersone;
                ((Paninoteca) locale).panini -= nPersone;
                canBook = true;
            }
        }

        return canBook;
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public void registraLocale(MyLocale newLocale) {
        locali.add(newLocale);
    }

    public void removeLocale(MyLocale locale) {
        locali.remove(locale);
    }

    public static LocaliManager createManager() {
        Scanner scan = new Scanner(System.in);
        LocaliManager lm = new LocaliManager();
        boolean continuare = true;

        // campi da riempire
        String nome, indirizzo;
        int postiDisponibili;
        HashMap<String, Float> menuPizzeria;
        int panini, birre;
        int tipo;

        while (continuare) {
            System.out.println("Inserire un locale? (y/n): ");
            continuare = scan.nextLine().charAt(0) == 'y';
            if (!continuare) break;

            System.out.println("Inserire il nome del locale:");
            nome = scan.nextLine();
            System.out.println("Inserire il l'indirizzo del locale:");
            indirizzo = scan.nextLine();
            System.out.println("Inserire il numero di posti disponibili:");
            postiDisponibili = scan.nextInt();
            scan.nextLine(); // drop the \n

            do {
                System.out.println("Pizzeria o paninoteca? (1/2):");
                tipo = scan.nextInt();
                scan.nextLine(); // drop the \n

                if (tipo != 1 && tipo != 2) System.out.println("Errore! Inserire una tipologia valida");
                else {
                    if (tipo == 1) { // è una pizzeria
                        menuPizzeria = Pizzeria.createMenu();
                        lm.registraLocale(new Pizzeria(nome, indirizzo, postiDisponibili,menuPizzeria));
                    }
                    else { // è una paninoteca
                        System.out.println("Inserire numero panini e birre:");
                        panini = scan.nextInt();
                        birre = scan.nextInt();
                        scan.nextLine(); scan.nextLine();

                        lm.registraLocale(new Paninoteca(nome, indirizzo, postiDisponibili, panini, birre));
                    }
                    System.out.println("Locale creato");
                }
            } while (tipo != 1 && tipo != 2);
        }

        scan.close();
        return lm;
    }


    public void printPizzerieByPizza(String nomePizza) {
        for (var a : locali) {
            if (a instanceof Pizzeria) {
                if (((Pizzeria) a).menu.containsKey(nomePizza)) {
                    float prezzo = ((Pizzeria) a).menu.get(nomePizza);
                    System.out.println(a + " " + nomePizza + "  $" + prezzo);
                }
            }
        }
    }


    @Override
    public String toString() {
        return "LocaliManager{" +
                "locali=" + locali +
                '}';
    }
}
