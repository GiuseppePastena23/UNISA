import javax.swing.*;
import java.util.List;
import java.util.stream.Stream;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame("titolo");
        JComboBox<Integer> comboBox = new JComboBox<Integer>(
                Stream.iterate(1, i -> i + 1).limit(100).toArray(Integer[]::new)
        );
        frame.add(comboBox);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
        new List<>().stream()
    }

}
