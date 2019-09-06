package Chp10;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class no2 extends JFrame {
	Container cp = getContentPane();
	
	public no2() {
		
		cp.setBackground(Color.GREEN);
		cp.addMouseMotionListener(new mal());
		
		setTitle("Let's Study");
		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	class mal implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			cp.setBackground(Color.yellow);
		}
		public void mouseMoved(MouseEvent e) {
			cp.setBackground(Color.blue);
		}
	}
	public static void main(String[] args) {
		new no2();
	}
}
