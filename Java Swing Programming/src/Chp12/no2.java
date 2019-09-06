package Chp12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class no2 extends JFrame {
	public no2(){
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		Point p = new Point(10, 10);
		
		public MyPanel() {
			setLayout(new FlowLayout());
			addMouseMotionListener(new MouseMotionListener() {
				public void mouseReleased(MouseEvent e) {
					p = e.getPoint();
					repaint();
				}
				public void mousePressed(MouseEvent e) {
					p = e.getPoint();
					repaint();
				}
				public void mouseExited(MouseEvent e) {
				}
				public void mouseEntered(MouseEvent e) {
				}
				public void mouseClicked(MouseEvent e) {
				}
				public void mouseDragged(MouseEvent e) {
					p = e.getPoint();
					repaint();
				}
				public void mouseMoved(MouseEvent e) {
				}
			});
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.blue);
			g.fillOval(p.x, p.y, 20, 20);
		}
	}
	static public void main(String[] args) {
		new no2();
	}
}