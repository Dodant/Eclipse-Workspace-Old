package Chp10;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class no1 extends JFrame {
	
	JLabel lb = new JLabel("Love Java");
	
	public no1(){
		Container cp = getContentPane();
		cp.setBackground(Color.ORANGE);
		cp.setLayout(new FlowLayout());

		lb.addMouseListener(new mal());
		cp.add(lb);
		setTitle("Let's Study");
		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		cp.setFocusable(true);
//		cp.requestFocus();
	}

	class mal implements MouseListener {
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {
			lb.setText("Love Java");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lb.setText("사랑해");
		}
	}
	
	public static void main(String[] args) {
		new no1();
	}
}
