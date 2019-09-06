import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SwingCalc extends JFrame{
	Container cp = getContentPane();
	CalcEngine eng = new CalcEngine();
	JTextField display = new JTextField(eng.getDisplay(), 12);
	
	public SwingCalc() {
		cp.setLayout(new BorderLayout());
		cp.add(new ResultPanel(), BorderLayout.NORTH);
		cp.add(new InputPanel(), BorderLayout.CENTER);
		setTitle("Calculator");
		setSize(220, 270);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	class ResultPanel extends JPanel{
		public ResultPanel() {
			setBackground(Color.GRAY);
			setLayout(new FlowLayout());
			display.setFont(new Font("Arial", Font.PLAIN, 20));
			display.setSize(130, 40);
			add(display);
		}
	}
	class InputPanel extends JPanel{
		public InputPanel(){
			setLayout(new GridLayout(4,4,3,3));
			
			JButton btn7 = new JButton("7");
			JButton btn8 = new JButton("8");
			JButton btn9 = new JButton("9");
			JButton btnPlus = new JButton("+");
			JButton btn4 = new JButton("4");
			JButton btn5 = new JButton("5");
			JButton btn6 = new JButton("6");
			JButton btnMinus = new JButton("-");
			JButton btn1 = new JButton("1");
			JButton btn2 = new JButton("2");
			JButton btn3 = new JButton("3");
			JButton btnMulti = new JButton("*");
			JButton btnC = new JButton("C");
			JButton btn0 = new JButton("0");
			JButton btnEqual = new JButton("=");
			JButton btnDiv = new JButton("/");
			
			btn7.addMouseListener(new ML());
			btn8.addMouseListener(new ML());
			btn9.addMouseListener(new ML());
			btnPlus.addMouseListener(new ML());
			btn4.addMouseListener(new ML());
			btn5.addMouseListener(new ML());
			btn6.addMouseListener(new ML());
			btnMinus.addMouseListener(new ML());
			btn1.addMouseListener(new ML());
			btn2.addMouseListener(new ML());
			btn3.addMouseListener(new ML());
			btnMulti.addMouseListener(new ML());
			btnC.addMouseListener(new ML());
			btn0.addMouseListener(new ML());
			btnEqual.addMouseListener(new ML());
			btnDiv.addMouseListener(new ML());

			add(btn7); add(btn8); add(btn9); add(btnPlus);
			add(btn4); add(btn5); add(btn6); add(btnMinus);
			add(btn1); add(btn2); add(btn3); add(btnMulti);
			add(btnC); add(btn0); add(btnEqual); add(btnDiv);

		}
	}
	class ML extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			eng.enter(btn.getText());
			display.setText(eng.getDisplay());
			repaint();
		}
	}
	public static void main(String[] args) {
		new SwingCalc();
	}
}
