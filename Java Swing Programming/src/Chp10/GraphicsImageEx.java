package Chp10;
// Down Here

import java.awt.*;
import javax.swing.*;

public class GraphicsImageEx extends JFrame{
	GraphicsImageEx() {
		setTitle("DrawImage");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();

		MyPanel panel = new MyPanel();
		
		c.add(panel);
		setSize(500, 500);
		setVisible(true);
	}
	//예제 12-6
	class MyPanel extends JPanel{
		ImageIcon icon = new ImageIcon("images/simpson.jpg");
		Image img = icon.getImage();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 50, 50, this);
		}	
	}
	//예제 12-7
//	class MyPanel extends JPanel{
//		ImageIcon icon = new ImageIcon("images/simpson.jpg");
//		Image img = icon.getImage();
//			
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//		}	
//	}
	//예제 12-8
//	class MyPanel extends JPanel{
//		ImageIcon icon = new ImageIcon("images/Logo.jpg");
//		Image img = icon.getImage();
//			
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(img, 200, 200, 500, 500, 600, 200, 900, 400, this);
//		}
//	}
	//예제 12-9
//	class MyPanel extends JPanel{
//		ImageIcon icon = new ImageIcon("images/Rainbow.gif");
//		Image img = icon.getImage();
//			
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.setClip(0,0,200,200);
//			g.drawImage(img, 0, 0, 400, 400, this);
//			g.setColor(Color.YELLOW);
//			g.setFont(new Font("Arial", Font.BOLD, 30));
//			g.drawString("RainBow!", 0, 30);
//		}
//	}
	public static void main(String[] args) {
		new GraphicsImageEx();
	}
}
