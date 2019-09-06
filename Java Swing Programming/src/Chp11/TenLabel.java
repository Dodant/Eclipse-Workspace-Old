package Chp11;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TenLabel extends JFrame {
	Container cp = getContentPane();
	private int count = 0;
	
	public TenLabel(){
		cp.setLayout(null);
		numRecur();
		setTitle("Ten 레이블 클릭");
		setSize(300, 300);
		setLocation(500, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	void numRecur() {
		for(int i = 0; i <= 9; i++) {
			JLabel num = new JLabel(Integer.toString(i));
			num.setBounds((int)(Math.random()*300), (int)(Math.random()*300), 20, 20);
			num.setFont(new Font("Arial", Font.PLAIN, 20));	//폰트 설정 
			num.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));	//외곽선 설정 
			num.addMouseListener(new ML());
			add(num);
		}
	}
	class ML extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			JLabel lb = (JLabel)e.getSource();
			if(count == Integer.parseInt(lb.getText())) {
				if(count == 9) {
					count = 0;
					lb.setVisible(false);
					remove(lb);
					numRecur();
					repaint();
				} else {
					lb.setVisible(false);
					remove(lb);
					count++;
	}}}}
	public static void main(String[] args) {
		new TenLabel();
	}
}