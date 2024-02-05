import core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow;

import javax.swing.*;
import java.awt.*;

public class GuiCorsi extends JFrame
{
    public static String randomString(int Lenght)
    {
        String caratteriPerStringa = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Inizializza un oggetto Random
        Random random = new Random();

        // Crea una StringBuilder per costruire la stringa random
        StringBuilder stringaRandom = new StringBuilder();

        // Genera la stringa random aggiungendo caratteri casuali
        for (int i = 0; i <= Lenght; i++) 
        {
            // Ottieni un indice casuale per i caratteri
            int indiceCasuale = random.nextInt(caratteriPerStringa.length());

            // Aggiungi il carattere corrispondente all'indice casuale alla stringa
            stringaRandom.append(caratteriPerStringa.charAt(indiceCasuale));
        }

        return(stringaRandom.toString());
    }

    public static NomiIndirizzi randomNomiIndirizzi()
    {
        Random random = new Random();
        int index = random.nextInt(NomiIndirizzi.values().length);   
        return(NomiIndirizzi.values()[index]);
    }

    public static Corso CreateRandomCorso(String tipo)
    {
        tipo = tipo.toLowerCase();
        Random random = new Random();
        
        String nome = randomString(10);
        String docente = randomString(10);
        int totaleOreLezioni = random.nextInt(100);

        switch(tipo)
        {
            case "dottorato":
            {
                int oreTotaleLaboratorio = random.nextInt(100);
                Corso dottorato = new Dottorato(nome, docente, oreTotaleLaboratorio, totaleOreLezioni);
                return(dottorato);
            }
            case "magistrale":
            {
                List<NomiIndirizzi> nomiIndirizzi = new ArrayList<>();
                for(int i = 0; i < 20; i++)
                {
                    nomiIndirizzi.add(randomNomiIndirizzi());
                }
                Corso magistrale = new Magistrale(nome, docente, nomiIndirizzi, totaleOreLezioni);
                return(magistrale);
            }
            case "triennale":
            {
                String linguacorso = randomString(10);
                Corso triennale = new Triennale(nome, docente, linguacorso, totaleOreLezioni);
                return(triennale);
            }
            default :
            {
                throw new RuntimeException("Non esiste il corso indicato");
            }
        }
    }

    public static void GUICORSI()
    {
        ProgammazioneDidattica progammazioneDidattica = new ProgammazioneDidattica();
        
        Random random = new Random();
        progammazioneDidattica.setNomeIndirizzo(randomNomiIndirizzi());
        progammazioneDidattica.setNumeroOreMassime(100000);
        progammazioneDidattica.setNumeroOreMinime(0);

        for(int i = 0; i < 20; i++)
        {
            progammazioneDidattica.AggiungiCorso(CreateRandomCorso("Triennale"));
            progammazioneDidattica.AggiungiCorso(CreateRandomCorso("Magistrale"));
            progammazioneDidattica.AggiungiCorso(CreateRandomCorso("Triennale"));
            progammazioneDidattica.AggiungiCorso(CreateRandomCorso("Dottorato"));
        }




        

        JFrame frame = new JFrame("TEST");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JLabel label = new JLabel("COSTO");
        JLabel ResultLabel = new JLabel();
        Corso ArrayCorsi[] = progammazioneDidattica.getListaCorsi().toArray(new Corso[0]);
        JComboBox<Corso> combobox = new JComboBox<Corso>(ArrayCorsi);
        JButton button = new JButton("VERIFICA");
        button.addActionListener
        (
            e->
            {
                ResultLabel.setText
                (
                    progammazioneDidattica.verifica() ? "Requisiti soddisfatti" : "Requisiti non soddisfatti"
                );
            }
        );

        frame.setLayout(new FlowLayout());
        frame.setSize(600, 600);

        frame.add(panel);
        panel.add(label);
        panel.add(ResultLabel);
        panel.add(button);
        panel.add(combobox);

        frame.setVisible(true);
    }

    public static void main (String args[])
    {
        GUICORSI();
    }
}

