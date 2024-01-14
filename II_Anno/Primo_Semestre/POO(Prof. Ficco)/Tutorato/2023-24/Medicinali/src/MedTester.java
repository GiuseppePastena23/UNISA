import javax.swing.*;


public class MedTester extends JFrame {
    public MedTester() {
        super("MedTester");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(100, 100);

        JButton button = new JButton("Premi");
        button.addActionListener((e) -> {
            MedSystem.stampaCondizione();
        });

        setVisible(true);
    }




    public static void main(String[] args) {
        new MedTester();
    }
}
