package Chp09;
import java.awt.*;
import javax.swing.*;

public class no6 extends JFrame {
	public no6() {
		Container cp = getContentPane();
		cp.setLayout(null);

		for (int i = 0; i < 20; i++) {
			JLabel label = new JLabel("");
			label.setBackground(Color.BLUE);
			int x = (int) (Math.random() * 200) + 50;
			int y = (int) (Math.random() * 200) + 50;
			label.setLocation(x, y);
			label.setSize(10, 10);
			label.setOpaque(true);
			cp.add(label);
		}

		setTitle("Random Labels");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new no6();
	}
}