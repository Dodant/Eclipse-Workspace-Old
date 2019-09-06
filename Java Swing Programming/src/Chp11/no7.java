package Chp11;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class no7 extends JFrame {
	Container cp = getContentPane();
	JSlider slide = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
	JLabel lb = new JLabel("I Love Java", SwingConstants.CENTER);
	
	public no7() {
		cp.setLayout(new BorderLayout());
		
		slide.setPaintTicks(true);
		slide.setPaintLabels(true);
		slide.setPaintTrack(true);
		slide.setMajorTickSpacing(20);
		slide.setMinorTickSpacing(5);
		slide.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				lb.setFont(new Font("Arial", Font.PLAIN, s.getValue()));
			}
		});
		cp.add(slide, BorderLayout.NORTH);
		cp.add(lb, BorderLayout.CENTER);
		
		setTitle("JSlider Practice Frame");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no7();
	}
}