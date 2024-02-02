import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class RectangleViewer {
	public static void main(String[] args) {
		final RectangleComponent comp = new RectangleComponent();
		
		class MousePressListener implements MouseListener {
			public void MousePressed(MouseEvent event) {
				int x = event.getX();
				int y = event.getY();
				component.moveTo(x, y);
			}
			
			void mouseReleased(MouseEvent event);
			void mouseClicked(MouseEvent event);
			void mouseEntered(MouseEvent event);
			void mouseExited(MouseEvent event);
		}
		
		MouseListener listener = new MousePressListener();
		comp.addMouseListener(listener);
		JFrame frame = new JFrame();
		frame.add(comp);
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		add(frame);
	}
	
	private static final int WIDTH = 300;
	private static final int HEIGTH = 400;
}
