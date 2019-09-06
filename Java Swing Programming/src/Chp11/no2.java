package Chp11;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class no2 extends JFrame {
	Container cp = getContentPane();
	JTextField nameTF = new JTextField(10);
	JComboBox<String> comboBox = new JComboBox<>();
	
	public no2() {
		cp.setLayout(new FlowLayout());
		nameTF.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				comboBox.addItem(t.getText());
				t.setText("");
			}
		});
		cp.add(nameTF);
		cp.add(comboBox);
		
		setTitle("JTextField and JComboBox");
		setSize(300, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no2();
	}
}
