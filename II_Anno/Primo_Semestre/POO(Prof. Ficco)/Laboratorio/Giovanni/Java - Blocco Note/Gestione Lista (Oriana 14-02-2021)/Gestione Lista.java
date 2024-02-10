package gestionelista;
import java.util.Scanner;
public class GestioneLista 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        int num, dim, pos=0, m=0, pm=0;
        System.out.println("Inserisci quanto è grande la lista");
        dim=in.nextInt();
        Lista l=new Lista(dim);
        int sc;
        do
        {
            System.out.println("1) Inserisci un elemento nella prima posizione libera");
            System.out.println("2) Inserisci un elemento nel mezzo, con traslazione");
            System.out.println("3) Inserisci un elemento nel mezzo, sovrascrivendo");
            System.out.println("4) Elimina un elemento, con traslazione");
            System.out.println("5) Elimina un elemento, senza traslazione");
            System.out.println("6) Stampa");
            System.out.println("7) Seleziona un elemento");
            System.out.println("8) Esci");
            sc=in.nextInt();
            switch(sc)
            {
                case 1:
                    if(l.getGra()==dim)
                        System.out.println("Lista piena");
                    else
                    {
                        System.out.println("Inserisci l'elemento");
                        num=in.nextInt();
                        l.inseriscico(num, dim);
                    }
                break;
                
                case 2:
                    if(l.getGra()==dim)
                        System.out.println("Lista piena");
                    else
                    {
                        System.out.println("Inserisci la posizione");
                        pos=in.nextInt();
                        if(l.getLis(dim)==0)
                        {
                            m=1;
                        }
                        if(m==1)
                        {
                            System.out.println("Ci sta posto, inserisci un elemento");
                            num=in.nextInt();
                            l.inseriscime(num, pos, dim);
                        }
                        else
                            System.out.println("La traslazione non può avvenire");
                    }
                break;
                
                case 3:
                    System.out.println("Inserisci l'elemento");
                    num=in.nextInt();
                    System.out.println("Inserisci la posizione");
                    pos=in.nextInt();
                    if(dim>pos)
                        l.inseriscimes(num, pos);
                    else
                        System.out.println("Posizione non valida");
                break;    
                
                case 4:
                    if(l.getGra()==0)
                        System.out.println("Lista vuota");
                    else
                    {
                        System.out.println("Inserisci la posizione");
                        pos=in.nextInt();
                        if(l.getLispos(pos)!=0)
                        {
                            if(dim>pos)
                                l.elimina(pos, dim);
                            else
                                System.out.println("Posizione non valida");
                        }
                        else
                            System.out.println("Non ci sono elementi qui");
                    }
                break;
                
                case 5:
                    if(l.getGra()==0)
                        System.out.println("Lista vuota");
                    else
                    {
                        System.out.println("Inserisci la posizione");
                        pos=in.nextInt();
                        if(l.getLispos(pos)!=0)
                        {
                            if(dim>pos)
                                l.eliminas(pos);
                            else
                                System.out.println("Posizione non valida");
                        }
                        else
                            System.out.println("Non ci sono elementi qui");
                    }
                break;
                
                case 6:
                    System.out.println(l.toString(dim));
                break;
                
                case 7:
                    if(l.getGra()==0)
                        System.out.println("Lista vuota");
                    else
                    {
                        System.out.println("Inserisci la posizione");
                        pos=in.nextInt();
                        if(dim>pos)
                            System.out.println("L'elemento è: " + l.seleziona(pos));
                        else
                            System.out.println("Posizione non valida");
                    }
                break;
                
                case 8:
                    System.out.println("Uscita");
                break;
             
                default:
                    System.out.println("SCELTA NON RICONOSCIUTA");
            }
        }while(sc!=8);
    }
}