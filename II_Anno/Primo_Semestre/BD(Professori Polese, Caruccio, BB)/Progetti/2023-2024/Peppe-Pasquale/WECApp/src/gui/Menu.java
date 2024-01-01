package gui;

import core.Queries;
import core.Query;
import core.QueryRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    public Menu() {


        // Setup della finestra
        this.setTitle("WECApp Menu");
        this.setIconImage(new ImageIcon("media/weclogo.png").getImage());
        this.setMinimumSize(new Dimension(500, 500));
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        // Crea il pannello con uno sfondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("media/carwallpaper.jpg").getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.add(buttonPanelCreator()); // aggiungo al pannello i bottoni


        // Aggiunge il pannello con sfondo alla finestra e bottoni alla finestra
        this.add(backgroundPanel);
        this.setVisible(true);
    }


    // disegna il wallpaper
    private static JPanel logoBackground(String filename) {
        JPanel panel = new JPanel(null)
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon(filename).getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);
        return panel;
    }


    // per ogni bottone presente aggiunge al pannello che ritorna
    private static JPanel buttonPanelCreator() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));
        panel.setOpaque(false);

        for (JButton button : createButtons()) {
            panel.add(button);
        }
        return panel;
    }


    /**
     * Crea i bottoni per ogni query e imposta il loro comportamento.
     * ci sono tre tipi di finestre pop-up:
     * <ol>
     * <li>PopUpTable: SEMPLICE query che richiede solo una tabella (SELECT * FROM ...)</li>
     * <li>PopUpPrompt: SINGOLA query che richiede un input</li>
     * <li>PopUpComplex: COMPLESSA query che richiede diverse operazioni (es. diverse fasi di input, update, controlli, datatype da gestire)</li>
     * </ol>
     * @return array di bottoni
     *
     */
    private static JButton[] createButtons() {
        int i = 0;
        JButton[] buttons = new JButton[Queries.queries.length];
        for (Query query : Queries.queries) {
            JButton button = new JButton(query.toString());

            if (query.requiresInput) {
                // e' una operazione complessa con diversi passaggi, deve essere in modo personalizzato
                if (query.isComplex) {
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new PopUpComplex(query);
                        }
                    });
                }

                else {
                    // e' una operazione semplice che non richiede molti passaggi ma ha bisogno di input
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new PopUpPrompt(query);
                        }
                    });
                }
            } else {
                // e' una query che richiede solo una tabella
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new PopUpTable(query);
                    }
                });
            }

            buttons[i] = button;
            i++;
        }
        return buttons;
    }
}
