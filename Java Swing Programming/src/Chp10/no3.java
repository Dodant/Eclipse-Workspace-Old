package Chp10;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class no3 extends JFrame {
	
	JLabel lb = new JLabel("Love Java");
	
	public no3() {
		
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
				StringBuffer sb = new StringBuffer(lb.getText());
				lb.setText(sb.reverse().toString());
			}
		}
		public void keyReleased(KeyEvent e) {}
	}
	public static void main(String[] args) {
		new no3();
	}
}
