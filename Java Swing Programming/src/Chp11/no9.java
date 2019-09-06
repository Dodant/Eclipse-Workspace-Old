package Chp11;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class no9 extends JFrame {
	Container cp = getContentPane();
	int cpuint;

	JButton rock = new JButton(new ImageIcon("Rock.jpg"));
	JButton scissor = new JButton(new ImageIcon("Scissor.jpg"));
	JButton paper = new JButton(new ImageIcon("Paper.jpg"));
	JLabel me = new JLabel("Me", new ImageIcon("Rock.jpg"), SwingConstants.RIGHT);
	JLabel cpu = new JLabel("CPU", new ImageIcon("Rock.jpg"), SwingConstants.RIGHT);
	JLabel result = new JLabel("Ready");

	public no9() {
		cp.setLayout(new FlowLayout());

		rock.addMouseListener(new myr());
		scissor.addMouseListener(new mys());
		paper.addMouseListener(new myp());

		cp.add(rock);
		cp.add(scissor);
		cp.add(paper);
		cp.add(me);
		cp.add(cpu);
		cp.add(result);

		setTitle("가위바위보 게임");
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	class myr extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			me.setIcon(new ImageIcon("Rock.jpg"));

			cpuint = (int) (Math.random() * 3);
			if (cpuint == 0) cpu.setIcon(new ImageIcon("Rock.jpg"));
			else if (cpuint == 1) cpu.setIcon(new ImageIcon("Scissor.jpg"));
			else cpu.setIcon(new ImageIcon("Paper.jpg"));

			if (cpuint == 0) result.setText("Same");
			else if (cpuint == 1) result.setText("Me!!!");
			else result.setText("CPU!!!");
		}
	}

	class mys extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			me.setIcon(new ImageIcon("Scissor.jpg"));

			cpuint = (int) (Math.random() * 3);
			if (cpuint == 0) cpu.setIcon(new ImageIcon("Rock.jpg"));
			else if (cpuint == 1) cpu.setIcon(new ImageIcon("Scissor.jpg"));
			else cpu.setIcon(new ImageIcon("Paper.jpg"));

			if (cpuint == 1) result.setText("Same");
			else if (cpuint == 0) result.setText("CPU!!!");
			else result.setText("Me!!!");
		}
	}

	class myp extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			me.setIcon(new ImageIcon("Paper.jpg"));

			cpuint = (int) (Math.random() * 3);
			if (cpuint == 0) cpu.setIcon(new ImageIcon("Rock.jpg"));
			else if (cpuint == 1) cpu.setIcon(new ImageIcon("Scissor.jpg"));
			else cpu.setIcon(new ImageIcon("Paper.jpg"));

			if (cpuint == 2) result.setText("Same");
			else if (cpuint == 1) result.setText("CPU!!!");
			else result.setText("ME!!!");
		}
	}

	public static void main(String[] args) {
		new no9();
	}
}