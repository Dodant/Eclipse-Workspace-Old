package Chp12;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class no7 extends JFrame {
	public no7(){
		super("마우스로 폐다각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private Vector<Integer> x = new Vector<Integer>();
		private Vector<Integer> y = new Vector<Integer>();

		public MyPanel() {
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					x.add(e.getX());
					y.add(e.getY());
					repaint();
				}
			});
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int xs [] = new int [x.size()];
			int ys [] = new int [y.size()];
			
			for(int i = 0; i < x.size(); i++) {
				xs[i] = x.get(i);
				ys[i] = y.get(i);
			}
			g.drawPolygon(xs,  ys,  xs.length);
		}
	}
	
	static public void main(String[] args) {
		new no7();
	}
}
