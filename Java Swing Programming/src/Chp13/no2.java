package Chp13;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class no2 extends JFrame {
	MyPanel circle = new MyPanel();

	no2() {
		setTitle("Random Move");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		circle.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JPanel circle = (JPanel) e.getSource();
				new Thread(){
					public void run() {
						while (true) {
							try {Thread.sleep(400);} 
							catch (InterruptedException e) {return;}
							int x = (int) (Math.random() * 200);
							int y = (int) (Math.random() * 200);
							circle.setLocation(x, y);
						}
					}
				}.start();
			}
		});
		add(circle);
		setSize(200, 200);
		setVisible(true);
	}
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.drawOval(50, 50, 50, 50);
		}
	}
	public static void main(String[] args) {
		new no2();
	}
}

