package Chp14;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class no3 extends JFrame{
	public no3() {
		JToolBar tb = new JToolBar();
		JButton exit = new JButton("종료");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		tb.add(exit);
		add(tb, BorderLayout.NORTH);
		setTitle("ToolBar");
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new no3();
	}
}
