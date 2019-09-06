package Chp10;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class no6 extends JFrame {
	
	JLabel lb = new JLabel("Love Java");
	
	
	public no6() {
		
		Container cp = getContentPane();
		cp.setLayout(null);
		lb.setBounds(100, 100, 80, 40);
		mal ml = new mal();
		cp.addMouseListener(ml);
		cp.setFocusable(true);
		cp.requestFocus();
		cp.add(lb);
		
		setTitle("Let's Study");
		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class mal extends MouseAdapter{
		public void mouseWheelMoved(MouseEvent e) {
			int x = (int)(Math.random()*300);
			int y = (int)(Math.random()*500);
			lb.setLocation(x,y);
		}
	}
	public static void main(String[] args) {
		new no6();
	}
}