package Chp11;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.*;

public class no8 extends JFrame {
	Container cp = getContentPane();
	int count = 10;
	
	public no8() {
		cp.setLayout(new FlowLayout());
		ButtonGroup group = new ButtonGroup();
		JRadioButton left = new JRadioButton("Left");
		JRadioButton right = new JRadioButton("Right", true);
		
		group.add(left);
		group.add(right);
		
		cp.add(left);
		cp.add(right);
		
		File f = new File("/Users/Dodanto/eclipse-workspace/JavaChp11/image");
		File[] imageFile = f.listFiles();
		Vector<ImageIcon> imageVec = new Vector<>();
		for (int i = 0; i < imageFile.length ; i++) {
			imageVec.add(new ImageIcon("image/" + imageFile[i].getName()));
		}
		JLabel imagelb = new JLabel(imageVec.get(0));
		imagelb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(left.isSelected()) count--;
				else count++;
				imagelb.setIcon(imageVec.get(count%imageFile.length));
			}
		});
		cp.add(imagelb);
		
		setTitle("Image Gallery Practice Frame");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new no8();
	}
}