import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Gui extends JFrame{

    public Gui(){
        super("Test");
        setSize(250, 260);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel generalPanel = generalPanel();
        
        add(generalPanel);
        
    }   

    public JPanel generalPanel(){
        JPanel p = new JPanel();
        p.add(infoPanel());
        return p;
    }

    public JPanel infoPanel(){
        JPanel p = new JPanel();

        p.setBorder(BorderFactory.createTitledBorder("InfoContatto"));

        return p;
    }

    public JPanel actionPanel(){
        JPanel p = new JPanel();
        return p;
    }
}