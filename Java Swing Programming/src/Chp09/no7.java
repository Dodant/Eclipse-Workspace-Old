package Chp09;
import java.awt.*;
import javax.swing.*;

public class no7 extends JFrame {
	public no7() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(new NorthPanel() , BorderLayout.NORTH);
		cp.add(new CenterPanel(), BorderLayout.CENTER);
		cp.add(new SouthPanel(), BorderLayout.SOUTH);

		setTitle("Calculator Frame");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new no7();
	}
}
class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.GRAY);
		add(new JLabel("수식입력"));
		add(new JTextField("				"));
	}
}
class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(new GridLayout(4, 4));
		add(new JButton("0"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
		add(new JButton("7"));
		add(new JButton("8"));
		add(new JButton("9"));
		add(new JButton("CE"));
		add(new JButton("계산"));
		add(new JButton("+"));
		add(new JButton("-"));
		add(new JButton("*"));
		add(new JButton("/"));
	}
}
class SouthPanel extends JPanel {
	public SouthPanel() {
		add(new JLabel("계산결과"));
		add(new JTextField("				"));
	}
}
