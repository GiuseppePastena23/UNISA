package WECPKG;

import javax.swing.*;


public class WEC extends JFrame {

    private JButton button1;
    private JPanel panel1;
    private JTabbedPane tabbedPane1;


    public WEC() {
        setTitle("WECApp");
        setSize(550, 550);
        setBounds(50, 50, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);

        new_vettura nv = new new_vettura();
        new_scuderia ns = new new_scuderia();
        new_componente nc = new new_componente();
        new_pilota np = new new_pilota();
        new_finanzia nf = new new_finanzia();
        new_partecipazione npa = new new_partecipazione();
        new_risultati rs = new new_risultati();
        displayquery q8 = new displayquery(Operazioni.get_finanziamenti());
        displayquery q9 = new displayquery(Operazioni.get_scuderie());
        displayquery q10 = new displayquery(Operazioni.get_piloti_casa());
        displayquery q11 = new displayquery(Operazioni.get_gm());
        displayquery q12 = new displayquery(Operazioni.get_costruttori());
        displayquery q13 = new displayquery(Operazioni.get_classifica_finale());
        displayquery q14 = new displayquery(Operazioni.get_classifica_parziale("aspirato"));
        displayquery q16 = new displayquery(Operazioni.get_classifica_parziale("turbo"));
        displayquery q15 = new displayquery(Operazioni.get_report());

        tabbedPane1.addTab("Vettura", nv);
        tabbedPane1.addTab("Scuderia",ns);
        tabbedPane1.addTab("Componenti",nc);
        tabbedPane1.addTab("Piloti", np);
        tabbedPane1.addTab("Finanziamenti", nf);
        tabbedPane1.addTab("Partecipazioni", npa);
        tabbedPane1.addTab("Risultati",rs);
        tabbedPane1.addTab("get_finanziamenti",q8);
        tabbedPane1.addTab("get_scuderie",q9);
        tabbedPane1.addTab("get_piloti_casa",q10);
        tabbedPane1.addTab("get_gm",q11);
        tabbedPane1.addTab("get_costruttori",q12);
        tabbedPane1.addTab("get_classifica_finale",q13);
        tabbedPane1.addTab("get_classifica_motori_aspirato",q16);
        tabbedPane1.addTab("get_classifica_motori_turbo",q14);
        tabbedPane1.addTab("get_report",q15);

        getContentPane().add(tabbedPane1);

    }

    public static void main(String[] args) {
        WEC wec = new WEC();
        wec.setVisible(true);
    }

}


