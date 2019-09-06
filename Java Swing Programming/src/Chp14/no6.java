package Chp14;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class no6 extends JFrame{
	JButton calc = new JButton("Calculate");
	JLabel result = new JLabel("계산 결과 출력");
	CalcDialog dialog = new CalcDialog(this, "Calculation Dialog");
	
	public no6() {
		Container cp = getContentPane();
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		cp.add(calc);
		cp.add(result);
		cp.setLayout(new FlowLayout());
		setTitle("ToolBar");
		setSize(250,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	class CalcDialog extends JDialog{
		private JTextField firstNo = new JTextField(10);
		private JTextField secondNo = new JTextField(10);
		private JButton addbtn = new JButton("ADD");
		
		public CalcDialog(JFrame frame, String title) {
			super(frame, title, true);
			setLayout(new FlowLayout());
			add(new JLabel("두 수를 더합니다 "));
			add(firstNo); add(secondNo); add(addbtn);
			setSize(200, 150);
			addbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int stn = Integer.parseInt(firstNo.getText());
					int ndn = Integer.parseInt(secondNo.getText());
					result.setText(stn + ndn + "");
					setVisible(false);
				}
			});
		}
	}
	public static void main(String[] args) {
		new no6();
	}
}
