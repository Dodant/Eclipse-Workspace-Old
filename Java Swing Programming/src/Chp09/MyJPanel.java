package Chp09;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class MyJPanel extends JPanel {


	public MyJPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("WOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn pressed");
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Fucking");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("fuck is pressed");
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Awesome!!");
		add(btnNewButton_2);

		JEditorPane dtrpnPublicStaticVoid = new JEditorPane();
		dtrpnPublicStaticVoid.setText("public static void main(String [] agrs)");
		add(dtrpnPublicStaticVoid);
		
		setSize(400,200);
		setVisible(true);
	}

	public static void main(String[] agrs) {
		new MyJPanel();
	}

}
