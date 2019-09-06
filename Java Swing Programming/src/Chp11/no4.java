package Chp11;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class no4 extends JFrame {
	Container cp = getContentPane();
	JLabel lb = new JLabel("금액");
	JTextField moneyTF = new JTextField(10);
	JButton calc = new JButton("계산");
	
	Integer[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; 
	JLabel[] billcoinlb = new JLabel[9];
	JTextField[] billcointf = new JTextField[9];
	JCheckBox[] billcoincb = new JCheckBox[9];
	
	public no4() {
		cp.setLayout(new BorderLayout());
		
		class inputPanel extends JPanel{
			public inputPanel() {
				add(lb);
				add(moneyTF);
				add(calc);
			}
		}
		class moneyPanel extends JPanel {
			public moneyPanel() {
				for(int i = 0; i < 9; i++) {
					billcoinlb[i] = new JLabel(money[i].toString() + "원"); add(billcoinlb[i]);
					billcointf[i] = new JTextField(10); add(billcointf[i]);
					billcoincb[i] = new JCheckBox(); add(billcoincb[i]);
				}
				billcoincb[8].setSelected(true);
				billcoincb[8].setVisible(false);
			}
		}
		moneyPanel mp = new moneyPanel();
		mp.setLayout(new GridLayout(9, 3));
		
		cp.add(new inputPanel(), BorderLayout.NORTH);
		cp.add(mp, BorderLayout.CENTER);
		
		calc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int moneyInput = Integer.parseInt(moneyTF.getText());
				for(int i = 0; i < 9; i++){
					if(billcoincb[i].isSelected()) {
						billcointf[i].setText(moneyInput/money[i] + "");
						moneyInput -= (moneyInput/money[i]) * money[i];
					}
				}
			}
		});
		
		setTitle("Money Changer");
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no4();
	}
}