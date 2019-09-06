package Chp13;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class no6 extends JFrame{
	Container cp = getContentPane();
	public no6() {
		cp.setLayout(null);
		cp.addMouseListener(new ML());
		setTitle("Bubble");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class Bubble extends JPanel implements Runnable{
		private Icon icon = new ImageIcon("images/chicken.jpg");
		public JLabel lb = new JLabel(icon);
		int x;
		int y;
		public Bubble() {
			x = (int)(Math.random()*500);
			y = (int)(Math.random()*500);
			lb.setBounds(x, y, 50, 50);
			cp.add(lb);
		}
		@Override
		public void run() {
			while(true) {
				lb.setLocation(x, y);
				y -= 5;
				try {
					Thread.sleep(50);
				} catch (Exception e) {return;}
			}
		}
	}
	class ML extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			Bubble bu = new Bubble();
			Thread th = new Thread(bu);
			th.start();
			cp.add(bu);
		}
	}
	public static void main(String[] args) {
		new no6();
	}
}
