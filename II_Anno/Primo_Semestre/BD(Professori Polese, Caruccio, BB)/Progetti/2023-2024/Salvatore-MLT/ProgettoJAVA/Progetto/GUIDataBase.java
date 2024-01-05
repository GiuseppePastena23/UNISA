package Progetto;

import Progetto.ClassiQuery.*;
import Progetto.ClassiQuery.Componenti.TipoComponente; //java devi morire
import Progetto.ClassiQuery.Gara.TipoGara;
import Progetto.OP;


import java.sql.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.management.Query;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import java.util.ArrayList;

public class GUIDataBase
{  

    public static void StartGUI()
    {
        JFrame frame = new JFrame("GUI DATABASE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        ArrayList<JButton> Bottoni = new ArrayList<>();

        String[] Operazioni = 
        {
            "Registrazione di una scuderia",
            "Inserimento dei dati di un’autovettura, compresi i componenti di cui è composta",
            "Aggiunta di un nuovo pilota ad un equipaggio",
            "Registrazione di un finanziamento per una scuderia",
            "Iscrizione di una vettura ad una gara",
            "Registrazione del risultato conseguito da ciascuna vettura iscritta ad una gara",
            "Verifica della possibilità di montare un componente su una vettura",
            "Per ciascuna scuderia, stampare la somma totale dei finanziamenti ricevuti",
            "Stampa annuale delle scuderie che hanno partecipato al campionato compreso il numero di finanziamenti",
            "Visualizzare i piloti che hanno vinto nel «circuito di casa»",
            "Per ciascuna scuderia, visualizzare la percentuale di gentleman driver di cui si compone l’equipaggio",
            "Stampa mensile dei costruttori compreso il numero di componenti che ha fornito",
            "Stampa della classifica finale dei punti conseguiti da tutte le vetture",
            "Stampa delle classifiche finali di punti per tipo di motore",
            "Stampare un report che elenchi ciascuna scuderia sulla base del rapporto punti/minuti di gara, mediando tra le macchine appartenenti a ciascuna scuderia"
        };

        for (String operazione : Operazioni) //crea tutti i bottoni
        {
            JButton button = new JButton(operazione);
            Bottoni.add(button);
        }

        //OP1
        JPanel OP1 = new JPanel(new GridLayout(6, 3));
        JLabel InserisciNome = new JLabel("Inserisci qui il nome");
        JLabel InserisciSedeCentrale = new JLabel("Inserisci qui la sede centrale");
        JTextField TextFieldNome = new JTextField();
        JTextField TextFieldSedeCentrale = new JTextField();
        Bottoni.get(1).addActionListener(new ActionListener() //imposto OP1 con bottone 1
        {

        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String Nome = TextFieldNome.getText();
                String SedeCentrale = TextFieldSedeCentrale.getText();
                Scuderia scuderia = new Scuderia(Nome, SedeCentrale);
                OP.OP1(scuderia);
            }
        });
        
        OP1.add(Bottoni.get(1));
        OP1.add(InserisciNome);
        OP1.add(TextFieldNome);
        OP1.add(InserisciSedeCentrale);
        OP1.add(TextFieldSedeCentrale);
        frame.add(OP1);

        //OP2
        JPanel OP2 = new JPanel(new GridLayout(6, 3));

        JLabel InserisciVettura = new JLabel("Inserisci qui la vettura");
        JLabel InserisciTelaio = new JLabel("Inserisci qui il telaio");
        JLabel InserisciCambio = new JLabel("Inserisci qui il cambio");
        JLabel InserisciMotore = new JLabel("Inserisci qui il motore");

        //input Vettura
        JTextField TextFieldVettura= new JTextField();
        //text field campi vettura
        JTextField TextFieldVetturaID = new JTextField();
        JTextField TextFieldScuderia = new JTextField();
        JTextField TextFieldNGara= new JTextField();
        JTextField TextFieldVetturaModello = new JTextField();

        //input Telaio
        JTextField TextFieldTelaio = new JTextField();
        //text field campi telaio
        JTextField TextFieldIdTelaio = new JTextField();
        JTextField TextFieldTipoTelaio = new JTextField();
        JTextField TextFieldCostoTelaio = new JTextField();
        JTextField TextFieldDataInstallazioneTelaio = new JTextField();
        JTextField TextFieldNomeScuderiaTelaio = new JTextField();
        JTextField TextFieldNomeCostruttoreTelaio = new JTextField();
        JTextField TextFieldMateriale = new JTextField();
        JTextField TextFieldPeso = new JTextField();

        //input Cambio
        JTextField TextFieldCambio = new JTextField();
        //text field campi Cambio
        JTextField TextFieldIdCambio = new JTextField();
        JTextField TextFieldTipoCambio = new JTextField();
        JTextField TextFieldCostoCambio = new JTextField();
        JTextField TextFieldDataInstallazioneCambio = new JTextField();
        JTextField TextFieldNomeScuderiaCambio = new JTextField();
        JTextField TextFieldNomeCostruttoreCambio = new JTextField();
        JTextField TextFieldNMarce = new JTextField();

        //input Motore
        JOptionPane.showInputDialog();
        JTextField TextFieldMotore = new JTextField();
        //text field campi Motore
        JTextField TextFieldIdMotore = new JTextField();
        JTextField TextFieldTipoMotore = new JTextField();
        JTextField TextFieldCostoMotore = new JTextField();
        JTextField TextFieldDataInstallazioneMotore = new JTextField();
        JTextField TextFieldNomeScuderiaMotore = new JTextField();
        JTextField TextFieldNomeCostruttoreMotore = new JTextField();
        JTextField TextFieldCilindrata = new JTextField();
        JTextField TextFieldTipoMotoreMotore = new JTextField(); //tipo motore DEL motore
        JTextField TextFieldNumeroCilindri = new JTextField();
        
        Bottoni.get(2).addActionListener(new ActionListener() //imposto OP2 con bottone 2
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String VetturaID  = TextFieldVetturaID.getText();
                String Scuderia = TextFieldScuderia.getText();
                String NGara = TextFieldNGara.getText();
                String VetturaModello = TextFieldVetturaModello.getText();

                Vettura vettura = new Vettura(VetturaID, Scuderia, Integer.parseInt(NGara), VetturaModello);



                OP.OP2(vettura,);
            }
        });
        
        OP1.add(Bottoni.get(1));
        OP1.add(InserisciNome);
        OP1.add(TextFieldNome);
        OP1.add(InserisciSedeCentrale);
        OP1.add(TextFieldSedeCentrale);
        frame.add(OP1);

        




        frame.setVisible(true);

    }

    public static void main (String args[])
    {
        StartGUI();
    }

}
