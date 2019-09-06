package Chp11;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.scene.control.ScrollPane;

public class no6 extends JFrame {

	Container cp = getContentPane();
	int count = 0;
	JTextArea ta = new JTextArea(7,20);
	JSlider slide = new JSlider(JSlider.HORIZONTAL, 0, 100, count);
	
	public no6() {
		cp.setLayout(new FlowLayout());
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setPaintTrack(true);
		slide.setMinorTickSpacing(5);
		slide.setMajorTickSpacing(20);
		slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				if(s.getValue() < count) {
					count = s.getValue();
					ta.setText(ta.getText().substring(0, count));
				}
			}
		});
		ta.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				slide.setValue(++count);
				if(count == 100) {
					System.out.println("100자를 초과하였습니다.");
					count = 99;
					e.consume();
				}
			}
		});
		
		cp.add(new JScrollPane(ta));
		cp.add(slide);
		
		setTitle("TextArea Practice Frame");
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no6();
	}
}