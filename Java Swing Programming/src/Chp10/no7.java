package Chp10;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.*;

public class no7 extends JFrame {
	
	JLabel lb = new JLabel("Love Java");
	
	public no7() {
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.addMouseWheelListener(new mal());
		lb.setFont(new Font("Arial", Font.PLAIN, 10));
		
		lb.setFocusable(true);
		lb.requestFocus();
		cp.add(lb);
		
		setTitle("Let's Study");
		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class mal extends MouseAdapter{
		public void mouseWheelMoved(MouseWheelEvent e) {
			int n = e.getWheelRotation();
			if (n < 0) {
				Font f =lb.getFont();
				int size = f.getSize();
				lb.setFont(new Font("Arial", Font.PLAIN, size-5));
			} else {
				Font f =lb.getFont();
				int size = f.getSize();
				lb.setFont(new Font("Arial", Font.PLAIN, size+5));
			}
		}
	}
	public static void main(String[] args) {
		new no7();
	}
}