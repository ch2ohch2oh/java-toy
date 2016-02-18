/**
 * A demo of Graphics2D adapted from Core Java Volume 1 
 * 
 * This program draws 100 small squares on the window and updates every 0.1 second.
 * 
 * @author ch3cooh
 *
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Graphics2DDemo {
	public static void main(String [] args) {
		SimpleFrame demo = new SimpleFrame();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setVisible(true);
	}
}

class SimpleFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
	
	public SimpleFrame() {
		setTitle("Simple frame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		System.out.println("Size of frame: " + getSize());
		DrawPanel panel = new DrawPanel();
		add(panel);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask () {
			@Override
			public void run() {
				panel.repaint();
			}
		}, 1000,100);
	}
}

class DrawPanel extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Dimension panelSize = getSize();
		Random rand = new Random();
		
		for(int i=0; i<SQUARE_NUMBER; i++)
			g2.draw(new Rectangle2D.Double(rand.nextInt(panelSize.width), rand.nextInt(panelSize.width), 10, 10));
	}
	
	public static final int  SQUARE_NUMBER = 1000;
}