import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Gui extends JFrame{

    public Gui(){
        super("Login");
        setSize(300,125);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel textFieldpanel = new JPanel();

        JPanel buttonPanel = new JPanel();
        textFieldpanel.setLayout(new GridLayout(2, 2));
        JButton okButton = new JButton("Ok");
        okButton.setPreferredSize(new Dimension(270,25));
        JLabel userLabel = new JLabel("User:");
        JTextField userField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passworField = new JPasswordField();
        passworField.setEchoChar('*');
        textFieldpanel.add(userLabel);
        textFieldpanel.setTitle
        textFieldpanel.add(userField);
        textFieldpanel.add(passwordLabel);
        textFieldpanel.add(passworField);
        buttonPanel.add(okButton);

    

        add(textFieldpanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        
    }
}