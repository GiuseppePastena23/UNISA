package GestioneDVD;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneDVD 
{
    public static void main(String[] args) 
    {
        int sc, prod, cont, i, nasc, j, min;
        String tito, regi, att, attt;
        DVD d = new DVD(" ", " ", 0);
        Attore a = new Attore(" ", " ", " ", 0);
        ArrayList<Attore> at;
        Scanner in = new Scanner(System.in);
        ArrayList<DVD> dvd = new ArrayList <> ();
        do
        {
            System.out.println("0) Uscita");
            System.out.println("1) Aggiungi DVD");
            System.out.println("2) Ricerca della partecipazione di un attore");
            System.out.println("3) Ricerca del più anziano per nazionalità");
            System.out.println("---------------------------");
            sc=in.nextInt();
            switch(sc)
            {
                case 0:
                    System.out.println("Uscita");
                break;
                
                default:
                    System.out.println("SCELTA SCONOSCIUTA");
                break;
                
                case 1:
                    System.out.println("Inserisci il titolo");
                    tito=in.next();
                    System.out.println("Inserisci il regista");
                    regi=in.next();
                    System.out.println("Inserisci l'anno di produzione");
                    prod=in.nextInt();
                    d.setTito(tito);
                    d.setRegi(regi);
                    d.setProd(prod);
                    System.out.println("Inserisci quanti attori ci sono");
                    cont=in.nextInt();
                    for(i=0;i<cont;i++)
                    {
                        System.out.println("Inserisci il nome");
                        att=in.next();
                        a.setNome(att);
                        System.out.println("Inserisci il cognome");
                        att=in.next();
                        a.setCogn(att);
                        System.out.println("Inserisci la nazionalità");
                        att=in.next();
                        a.setNazi(att);
                        System.out.println("Inserisci l'anno di nascita");
                        nasc=in.nextInt();
                        a.setNasc(nasc);
                    }
                    dvd.add(d);
                break;
                
                case 2:
                    System.out.println("Inserire il nome e il cognom dell'attore");
                    att=in.next();
                    cont=0;
                    for(i=0;i<dvd.size();i++)
                    {
                        d=dvd.get(i);
                        at=d.getAtt();
                        for(j=0;j<at.size();i++)
                        {
                            a=at.get(i);
                            attt=a.getNome() + " " + a.getCogn();
                            if(att.equals(attt))
                            {
                                cont++;
                                System.out.println("Titolo: " + d.getTito());
                            }
                        }
                    }
                    if(cont==0)
                        System.out.println("Non ha partecipato a nessun film");
                break;
                
                case 3:
                    System.out.println("Inserisci la nazionalità");
                    att=in.next();
                    cont=0;
                    min=0;
                    for(i=0;i<dvd.size();i++)
                    {
                        d=dvd.get(i);
                        at=d.getAtt();
                        for(j=0;j<at.size();i++)
                        {
                            a=at.get(i);
                            if(att.equals(a.getNazi()))
                            {
                                nasc=a.getNasc();
                                if(nasc<min)
                                {
                                    cont++;
                                    min=nasc;
                                }
                            }
                        }
                    }
                    if(cont!=0)
                    {
                        for(i=0;i<dvd.size();i++)
                        {
                            d=dvd.get(i);
                            at=d.getAtt();
                            for(j=0;j<at.size();i++)
                            {
                                a=at.get(i);
                                nasc=a.getNasc();
                                if(nasc==min && att.equals(a.getNazi()))
                                    System.out.println("Il più vecchio è: " + a.getNome() + " " + a.getCogn());
                            }
                        }
                    }
                    else
                        System.out.println("Non ci sono attori di quella nazionalità");
                break;   
            }
        }while(sc!=0);
    }
}