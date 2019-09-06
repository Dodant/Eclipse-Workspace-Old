package Chp12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//public class no6 extends JFrame {
//	public no6(){
//		super("이미지 그리기 연습");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
//		setContentPane(new MyPanel());
//		setVisible(true);
//		setSize(300,300);
//	}
//	class MyPanel extends JPanel {
//		int x = this.getWidth() / 10;
//		int y = this.getHeight() / 10;
//		public MyPanel() {
//			setLayout(new FlowLayout());
//		}
//		public void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.setColor(Color.blue);
//			for(int i = 0; i < 10 ; i++) {
//				g.drawLine(x, 0, x, this.getHeight());
//				x += this.getWidth() / 10;
//			}
//			for(int i = 0; i < 10 ; i++) {
//				g.drawLine(0, y, this.getWidth(), y);
//				y += this.getHeight() / 10;
//			}
//		}
//	}
//	static public void main(String[] args) {
//		new no6();
//	}
//}

public class no6 extends JFrame {
	public no6(){
		super("이미지 그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		MyPanel mp = new MyPanel();
		setContentPane(mp);
		setVisible(true);
		setSize(400, 400);
	}
	class MyPanel extends JPanel {
		
		public MyPanel() {
			setSize(400, 400);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			int x = 0;
			int y = 0;
			int x1 = getWidth() / 2;
			int y1 = getHeight() / 2;
			int x2 = getWidth();
			int y2 = getHeight();
			for(int i = 0; i < 10 ; i++) {
				g.drawLine(x1, y, x, y1);
				g.drawLine(x1, y, x2, y1);
				g.drawLine(x, y1, x1, y2);
				g.drawLine(x1, y2, x2, y1);
				y += 10;
				x += 10;
				x2 -= 10;
				y2 -= 10;

			}
		}
	}
	static public void main(String[] args) {
		new no6();
	}
}