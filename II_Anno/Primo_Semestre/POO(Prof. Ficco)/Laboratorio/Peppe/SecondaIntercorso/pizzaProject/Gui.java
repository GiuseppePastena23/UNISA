import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
public class Gui {
    public Gui() {
        JFrame frame = new JFrame("Finestra");
        JButton button = new JButton("Print Pizzerie by pizza");
        JTextField textField = new JTextField();
        JButton button2 = new JButton();

        LocaliManager man = new LocaliManager();

        Menu menu1 = new Menu();
        menu1.addProdotto(new Pizza("Margherita", 10));
        menu1.addProdotto(new Pizza("Napoli", 12));
        menu1.addProdotto(new Pizza("Quattro Formaggi", 15));

        Menu menu2 = new Menu();
        menu2.addProdotto(new Pizza("Diavola", 11));
        menu2.addProdotto(new Pizza("Capricciosa", 13));
        menu2.addProdotto(new Pizza("Vegetariana", 14));

        
        man.addLocale(new Pizzeria("aaa", "randoma", 0, menu1));
        

        // Create additional pizzerias with random values
        for (int i = 0; i <= 10; i++) {
            String name = "Pizzeria " + i;
            String address = "Via Random " + i;
            int seatingCapacity = (int) (Math.random() * 100) + 1;
            Menu menu = new Menu();
            Menu randomMenu = Math.random() < 0.5 ? menu1 : menu2;
            man.addLocale(new Pizzeria(name, address, seatingCapacity, randomMenu));
        }
        for (int i = 1; i <= 5; i++) {
            String name = "Paninoteca " + i;
            String address = "Via Random " + i;
            int seatingCapacity = (int) (Math.random() * 50) + 1;
            int sandwichCount = (int) (Math.random() * 10) + 1;
            int drinkCount = (int) (Math.random() * 10) + 1;
            man.addLocale(new Paninoteca(name, address, seatingCapacity, sandwichCount, drinkCount));
        }

        button.addActionListener(e -> {
            man.printPizzerieByPizza(textField.getText());
        });

        button2.addActionListener(e -> {
            man.salvaNoPosti("file.txt");
        });

        frame.add(button);
        frame.add(textField);
        frame.add(button2);

        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2, 1, 10, 10));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Gui();
    }
}


