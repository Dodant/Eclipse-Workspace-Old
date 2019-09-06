package Chp10;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class no5 extends JFrame {
	
	JLabel lb = new JLabel("Love Java");
	
	public no5() {
		
		Container cp = getContentPane();
		setLayout(new FlowLayout());
		lb.setFont(new Font("Arial", Font.PLAIN, 10));
		lb.addKeyListener(new kal());
		lb.setFocusable(true);
		lb.requestFocus();
		cp.add(lb);
		
		setTitle("Let's Study");
		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class kal implements KeyListener{
		public void keyTyped(KeyEvent e) {}
		public void keyPressed(KeyEvent e) {
			if(e.getKeyChar() == '+') {
				Font f =lb.getFont();
				int size = f.getSize();
				lb.setFont(new Font("Arial", Font.PLAIN, size+5));
			}
			if(e.getKeyChar() == '_') {
				Font f =lb.getFont();
				int size = f.getSize();
				lb.setFont(new Font("Arial", Font.PLAIN, size-5));
			}
			
		}
		public void keyReleased(KeyEvent e) {}
	}
	public static void main(String[] args) {
		new no5();
	}
}