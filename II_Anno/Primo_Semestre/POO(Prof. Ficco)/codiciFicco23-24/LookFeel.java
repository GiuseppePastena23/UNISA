import javax.swing.*;	//servono JFrame e UIManager

public class LookFeel extends JFrame {
	
	public LookFeel (String titolo) {
		super(titolo);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		/*UIManager.getSystemLookAndFeelClassName()
		"com.sun.java.swing.plaf.motif.MotifLookAndFeel“,
		UIManager.getCrossPlatformLookAndFeelClassName()
		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
		"javax.swing.plaf.mac.MacLookAndFeel"*/
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LookFeel frame = new LookFeel("SwingApplication");
		
		frame.setVisible(true);
	}
}