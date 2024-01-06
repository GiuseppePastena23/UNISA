package gui;

import core.university.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;

import core.university.Category;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.function.Predicate;



public class Gui extends JFrame{

    static StudentManager sm = new StudentManager();
    
    public Gui(){
        super("Students Manager for UNISA");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel p1 = panel1();
        JPanel p2 = panel2();
        JPanel p3 = panel3();
        
        





























        
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(p3, BorderLayout.SOUTH);
        setVisible(true);
    }

    private static JPanel panel1(){
        JPanel panel1 = new JPanel();
        JButton saveOnFile_Button = new JButton("Salva su file");
        
        saveOnFile_Button.addActionListener(e -> sm.saveOnFile("Studenti.txt"));
        panel1.add(saveOnFile_Button);
        return panel1;
    }

    private static JPanel panel2(){
        JPanel panel1 = new JPanel();
        JLabel name_Label = new JLabel("Nome");
        JTextField textFieldName = new JTextField(10);
        JLabel surname_Label = new JLabel("Cognome");
        JTextField textFieldSurname = new JTextField(10);
        JLabel age_Label = new JLabel("Eta'");
        JComboBox<Integer> age_ComboBox = new JComboBox<>();
        for(int i = 0; i < 50; i++){
            age_ComboBox.addItem(i);
        }
        JLabel cat_Label = new JLabel("Categoria");
        JComboBox<Category> category_ComboBox = new JComboBox<>(Category.values());
        JButton add_Button = new JButton("Aggiungi");

        

        try {
            add_Button.addActionListener(e -> sm.addStudent(new Student(textFieldName.getText(), textFieldSurname.getText(), (int)age_ComboBox.getSelectedItem(), (Category)category_ComboBox.getSelectedItem())));
        }
        catch(CampiVuotiException e){
            
        }

        panel1.add(name_Label);
        panel1.add(textFieldName);
        panel1.add(surname_Label);
        panel1.add(textFieldSurname);
        panel1.add(age_Label);
        panel1.add(age_ComboBox);
        panel1.add(cat_Label);
        panel1.add(category_ComboBox);
        panel1.add(add_Button);
        return panel1;
    }

    private static JPanel panel3(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        JButton button1 = new JButton("Studenti per eta'");
        JButton button2 = new JButton("Studenti fuori corso");
        JButton button3 = new JButton("Studenti over 30");
        JButton button4 = new JButton("Studenti under 30");
        
        button1.addActionListener(e -> sm.getStudents()
        .stream()
        .sorted((s1, s2) -> s1.getAge() - s2.getAge()).forEach(s -> System.out.println(s)));
        button2.addActionListener(e -> sm.getStudents().stream().filter(s -> s.getCat() == Category.FUORI_CORSO).forEach(s -> System.out.println(s)));
        button3.addActionListener(e -> sm.getStudents().stream().filter(s -> s.getAge() > 30).forEach(s -> System.out.println(s)));
        button4.addActionListener(e -> sm.getStudents().stream().filter(s -> s.getAge() < 30).forEach(s -> System.out.println(s)));
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        return panel1;
    }
    
    public static void main(String[] args) {
        Gui gui = new Gui();
    }
}
