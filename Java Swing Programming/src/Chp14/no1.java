package Chp14;
import java.awt.*;
import javax.swing.*;

public class no1 extends JFrame{
	public no1() {
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenu edit = new JMenu("편집");
		JMenu view = new JMenu("보기");
		JMenu input = new JMenu("입력");
		JMenuItem zoom = new JMenuItem("화면확대");
		JMenuItem margin = new JMenuItem("쪽윤곽");
		
		view.add(zoom);
		view.add(margin);
		
		mb.add(file);
		mb.add(edit);
		mb.add(view);
		mb.add(input);

		setJMenuBar(mb);
		setTitle("Menu 만들기");
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new no1();
	}
}
