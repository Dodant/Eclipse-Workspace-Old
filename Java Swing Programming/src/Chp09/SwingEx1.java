package Chp09;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//public class no1 extends JFrame{
//	public no1(){
//		setTitle("Let's Study Java");
//		setSize(400,200);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setVisible(true);
//	}
//	public static void main(String[] args) {
//		new no1();
//	}
//}

public class SwingEx1{
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
	
}

class MyFrame extends JFrame{
	public MyFrame() {
		JButton btn1 = new JButton("Button1");
		JButton btn2 = new JButton("Button2");
		JLabel lb1 = new JLabel("JLabel");
		
		Mylis lis  = new Mylis();
		btn1.addActionListener(lis);
		
		Container cp = this.getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		//cp.setLayout(null);
		cp.add(btn1);
		cp.add(btn2);
		cp.add(lb1);
		cp.add(new MyJPanel());
				
		setTitle("첫번쨰 프래임");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class Mylis implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("btn pressed");
		}
	}
}