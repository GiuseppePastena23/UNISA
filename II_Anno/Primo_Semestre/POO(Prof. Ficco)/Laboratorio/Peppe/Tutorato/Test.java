import java.util.ArrayList;

public class Test{
    public static void main(String[] args) {
        Container c = new Container(100);
        Imballaggio  i = new Imballaggio(1, 1);
        Ente e = new Ente("Sbura", "Via sbura 22");
        Certificato ce = new Certificato(e, "validissimo e sburoso");

        ProdottoInMagazzino p = new ProdottoInMagazzino("cavolo", 1, ce, "A1");
        ProdottoInSpedizione p1 = new ProdottoInSpedizione("barbabietola", 2, ce, i, "Salerno");

        // Create additional instances with different values
        ProdottoInMagazzino p2 = new ProdottoInMagazzino("patate", 3, ce, "B2");
        ProdottoInSpedizione p3 = new ProdottoInSpedizione("carote", 4, ce, i, "Napoli");

        // Create 10 more instances with different values
        ProdottoInMagazzino p4 = new ProdottoInMagazzino("zucchine", 5, ce, "C3");
        ProdottoInSpedizione p5 = new ProdottoInSpedizione("peperoni", 6, ce, i, "Roma");
        ProdottoInMagazzino p6 = new ProdottoInMagazzino("melanzane", 7, ce, "D4");
        ProdottoInSpedizione p7 = new ProdottoInSpedizione("pomodori", 8, ce, i, "Milano");

        c.addProdotto(p);
        System.out.println("Added product: " + p.getName());

        c.addProdotto(p1);
        System.out.println("Added product: " + p1.getName());

        c.addProdotto(p2);
        System.out.println("Added product: " + p2.getName());

        c.addProdotto(p3);
        System.out.println("Added product: " + p3.getName());

        c.addProdotto(p4);
        System.out.println("Added product: " + p4.getName());

        c.addProdotto(p5);
        System.out.println("Added product: " + p5.getName());

        c.addProdotto(p6);
        System.out.println("Added product: " + p6.getName());

        c.addProdotto(p7);
        System.out.println("Added product: " + p7.getName());

        System.out.println(c.getPesoTotale());

        for(Prodotto pa : c.getProdotti(0, 100))
        {
            System.out.println(pa);
        }
        
    }
   
}
