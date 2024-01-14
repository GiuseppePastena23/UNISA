import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;

public class Gui extends JFrame{
    
    
    public Gui(){
        ManagerLavoratori lavoratori = new ManagerLavoratori();
       
        // Creazione delle istanze di Lavoratore
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Creazione dei pulsanti
        JButton button1 = new JButton("Stampa Lavoratori");
        button1.addActionListener(e -> {lavoratori.saveLavoratori("file.txt");});
        JButton button2 = new JButton("Leggi Lavoratori");
        button1.addActionListener(e -> {lavoratori.readLavoratori("file.txt");});
        JButton button3 = new JButton("Stampa su terminale");
        button3.addActionListener(e -> {lavoratori.stampaLavoratoriTerminale();});

        // Creazione del campo di testo
        JTextField textField = new JTextField();

        // Aggiunta dei componenti alla finestra
        setLayout(new GridLayout(3, 1));
        add(button1);
        add(button2);
        add(button3);
    
        add(textField);

        setVisible(true);
    }

    public static void main(String[] args) {
        
        // Aggiunta dei lavoratori alla lista
        new Gui();
    }
}
