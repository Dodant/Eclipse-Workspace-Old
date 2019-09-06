package Chp11;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class no5 extends JFrame {
	Container cp = getContentPane();
	JSlider slide = new JSlider(JSlider.HORIZONTAL, 100, 200, 150);
	JLabel slidValue = new JLabel(slide.getValue() + "");
	
	public no5() {
		cp.setLayout(new FlowLayout());
		slide.setPaintLabels(true);
		slide.setPaintTrack(true);
		slide.setPaintTicks(true);
		slide.setMajorTickSpacing(20);
		
		slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slidValue.setText(slide.getValue() + "");
			}
		});
		cp.add(slide);
		cp.add(slidValue);
		
		setTitle("JSlider Practice Frame");
		setSize(300, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no5();
	}
}