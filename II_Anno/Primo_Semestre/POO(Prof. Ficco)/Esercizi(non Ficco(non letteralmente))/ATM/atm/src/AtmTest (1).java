import javax.swing.JOptionPane;

public class AtmTest {
    public static void main(String[] args) throws Exception {

        Atm atm = new Atm();
        String str = JOptionPane.showInputDialog(atm.toString());
        while(str != null){
            atm.sendInput(str);
            str = JOptionPane.showInputDialog(atm.toString());
        }
        
    }
}
