package Chp09;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class no2 extends JFrame{
	private JLabel imagelb = new JLabel();
	
	public no2() {
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem open = new JMenuItem("열기");
		open.addActionListener(new OpenActionListener());
		file.add(open);
		mb.add(file);
		setJMenuBar(mb);
		
		getContentPane().add(imagelb, BorderLayout.CENTER);
		setTitle("메뉴로 배경 이미지 로딩하기");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	class OpenActionListener implements ActionListener {
		private JFileChooser chooser;
		public OpenActionListener() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filepath = chooser.getSelectedFile().getPath();
			imagelb.setIcon(new ImageIcon(filepath));
			pack();
		}
	}
	public static void main(String[] args) {
		new no2();
	}
}
