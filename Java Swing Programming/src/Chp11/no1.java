package Chp11;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class no1 extends JFrame {
	Container cp = getContentPane();
	JButton btn = new JButton("test button");
	JCheckBox btnEnabled = new JCheckBox("버튼 비활성화");
	JCheckBox btnVisible = new JCheckBox("버튼 감추기");
	
	public no1() {
		cp.setLayout(new FlowLayout());
		btnEnabled.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) btn.setEnabled(false);
				else btn.setEnabled(true);
			}
		});
		btnVisible.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) btn.setVisible(false);
				else btn.setVisible(true);
			}
		});
		cp.add(btnEnabled);
		cp.add(btnVisible);
		cp.add(btn);
		setTitle("CheckBox Practice");
		setSize(300, 100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no1();
	}
}
