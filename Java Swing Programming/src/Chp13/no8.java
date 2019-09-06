package Chp13;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Vector;
import javax.swing.*;

public class no8 extends JFrame {
	private BackGround panel = new BackGround();
 	public no8() {
		setTitle("Snow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new BackGround());
		setSize(900, 600);
		setVisible(true);		
	}
 	class BackGround extends JPanel {
 		Vector<Point> snowVector = new Vector<Point>(50);
		private ImageIcon icon = new ImageIcon("images/canvas4.jpg");
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			drawSnow(g);
		}
		public BackGround() {
			this.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					addSnow();
					new SnowThread().start();
					BackGround.this.removeComponentListener(this);
				}				
			});
		}
		void addSnow() {
			for(int i=0; i<50; i++) {
				Point p = new Point((int)(Math.random()*getWidth()), (int)(Math.random()*getHeight()));
				snowVector.add(p);
			}
		}
		void drawSnow(Graphics g) {
			g.setColor(Color.WHITE);			
			for(int i=0; i<snowVector.size(); i++) {
				Point p = snowVector.get(i);
				g.fillOval(p.x, p.y, 10, 10);			
			}
		}
		void changeSnowPosition() {
			for(int i=0; i<50; i++) {
				Point p = snowVector.get(i);
				int xDir = Math.random() > 0.5 ? 1 : -1; 
				int offsetX = (int)(Math.random()*3)*xDir;
				int offsetY = (int)(Math.random()*7);
				p.x += offsetX;
				if(p.x < 0) p.x = 0;
				p.y += offsetY;
				if(p.y > getHeight()) { 
					p.x = (int)(Math.random()*getWidth());
					p.y = 5;
				}
			}		
		}
		class SnowThread extends Thread {
			public void run() {
				while(true) {
					try {
						sleep(300);
					} catch (InterruptedException e) { return; }
					changeSnowPosition();
					repaint();
				}
			}
		}
	}
	public static void main(String [] args) {
		new no8();
	}
}