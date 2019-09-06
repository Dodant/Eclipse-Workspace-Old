package Chp10;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class no4 extends JFrame {
	
	JLabel lb = new JLabel("Love Java");
	
	public no4() {
		
		Container cp = getContentPane();
		setLayout(new FlowLayout());
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
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				String str = lb.getText().substring(0, 1);
				lb.setText(lb.getText().substring(1) + str);
			}
		}
		public void keyReleased(KeyEvent e) {}
	}
	public static void main(String[] args) {
		new no4();
	}
}
