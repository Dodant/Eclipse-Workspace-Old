package Chp09;
import java.awt.*;
import javax.swing.*;

public class no8 extends JFrame {
	public no8() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(new NorthPanel0(), BorderLayout.NORTH);
		cp.add(new CenterPanel0(), BorderLayout.CENTER);
		cp.add(new SouthPanel0(), BorderLayout.SOUTH);

		setTitle("Variety of Label Frame");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	class NorthPanel0 extends JPanel {
		public NorthPanel0() {
			setBackground(Color.GRAY);
			setLayout(new FlowLayout());
			add(new JButton("Open"));
			add(new JButton("Close"));
			add(new JButton("Exit"));
		}
	}
	class CenterPanel0 extends JPanel {
		public CenterPanel0() {
			setLayout(null);
			for (int i = 0; i < 10; i++) {
				JLabel label = new JLabel("*");
				label.setForeground(Color.RED);
				int x = (int) (Math.random() * 170) + 30;
				int y = (int) (Math.random() * 170) + 30;
				label.setBounds(x, y, 10, 10);
				label.setOpaque(true);
				add(label);
			}
		}
	}
	class SouthPanel0 extends JPanel {
		public SouthPanel0() {
			add(new JLabel("Word Input"));
			add(new JTextField("		"));
		}
	}
	public static void main(String[] args) {
		new no8();
	}
}
