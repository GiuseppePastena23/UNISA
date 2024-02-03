import java.util.function.*;
import java.util.stream.Collectors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Esercizio
{
    interface Drawable
    {
        public void draw();
    }

    public static void main(String[] args)
    {
        /* 
        int width = 10;
        Drawable d = ()->System.out.println("Drawing "+width);
        d.draw();

        Supplier<Double> getPiValue = ()-> {return 3.1415;};
        System.out.println(getPiValue.get());

        Function<String, String> RevString = (Normale) -> {
             StringBuilder rev = new StringBuilder();
             for (int i = Normale.length()-1; i >= 0 ; i--)
             {
                rev.append(Normale.charAt(i));
             }
             return(rev.toString());
            };
        //int to double
        Integer suca = 10;
        Function<Integer, Double> IntToDouble = (PALLE) -> {return (double) PALLE;};
        System.out.println(IntToDouble.apply(suca));
        System.out.println(RevString.apply("alucarD"));

        

        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10));

        JFrame testFrame = new JFrame("TEST");
        testFrame.setLayout(new FlowLayout());
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setSize(600, 600);

        JPanel testPanel = new JPanel();
        testPanel.setLayout(new GridLayout(3, 1));
        JLabel testLabel = new JLabel("Ecco a te il frocio TEST");
        JTextArea testTextArea = new JTextArea("");
        testTextArea.setEditable(false);
        JButton testButton = new JButton("CLICK ME");
        testButton.addActionListener(e -> {testTextArea.setText("SEI FROCIO");});
        JOptionPane testOptionPane = new JOptionPane("sesso");

        testPanel.add(testLabel);
        testPanel.add(testButton);
        testPanel.add(testTextArea);
        testFrame.add(testPanel);

        
        testFrame.setVisible(true); */

        List<Integer> test = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        while(i < 20)
        {
            test.add(random.nextInt());
            i++;
        }
        System.out.println(test);
        
        test.stream()
            .filter((A)->A>=0)
            .sorted((A, B) -> A.intValue() - B.intValue())
            .forEach((A)->System.out.print(A +" "));

        HashMap<Integer, String> testHash = new HashMap();
        testHash.put(1, "sex");
        System.out.println(testHash.get(1));
        testHash.remove(1);
        System.out.println(testHash);

        JButton testButton = new JButton("Click me");
        testButton.addActionListener(e -> {fai la cosa});

        
    }
}