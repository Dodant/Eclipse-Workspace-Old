package Chp14;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class no4 extends JFrame{
	public no4() {
		JToolBar tb = new JToolBar();
		JLabel idlb = new JLabel("학번:");
		JTextField idtf = new JTextField(15);
		idtf.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if((e.getKeyChar() < '0') || (e.getKeyChar() > '9')) {
					JOptionPane.showMessageDialog(null, ch + "는 숫자키가 아닙니다.\n숫자를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
					e.consume();
				}
			}
		});
		tb.add(idlb);
		tb.add(idtf);
		add(tb, BorderLayout.SOUTH);
		setTitle("ToolBar");
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new no4();
	}
}
