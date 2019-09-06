package Chp14;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class no8 extends JFrame {
	private Clip clip1, clip2, clip3, clip4;
	File audioFile1, audioFile2, audioFile3, audioFile4;
	private AudioInputStream audioStream;
	String filepath, filename;
	JCheckBox audioCheck[] = { new JCheckBox("Wolf.wav"), new JCheckBox("Drums.wav"), new JCheckBox("Siren.wav"), new JCheckBox("hiphop.wav")};

	public no8() {
		Container cp = getContentPane();
		JLabel infolb = new JLabel("체크된 곡만 순서대로 한 번 연주합니다.");
		JButton playbtn = new JButton("Play");
		JButton stopbtn = new JButton("Stop");
		Box audioBox = Box.createVerticalBox();
		Box btnBox = Box.createHorizontalBox();

		cp.add(infolb);
		audioBox.add(audioCheck[0]);
		audioBox.add(audioCheck[1]);
		audioBox.add(audioCheck[2]);
		audioBox.add(audioCheck[3]);
		audioCheck[0].addItemListener(new MyCheckBoxListener());
		audioCheck[1].addItemListener(new MyCheckBoxListener());
		audioCheck[2].addItemListener(new MyCheckBoxListener());
		audioCheck[3].addItemListener(new MyCheckBoxListener());
		playbtn.addActionListener(new PlayAudio());
		stopbtn.addActionListener(new StopAudio());
		btnBox.add(playbtn);
		btnBox.add(stopbtn);
		cp.add(audioBox);
		cp.add(btnBox);
		setLayout(new FlowLayout());
		setTitle("오디오 연주");
		setSize(220, 210);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	class MyCheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			JCheckBox cb = (JCheckBox) e.getSource();
			String s = cb.getText();
			Clip clip;
			File audioFile;
			if (e.getStateChange() == ItemEvent.SELECTED) {
				try {
					clip = AudioSystem.getClip();
					audioFile = new File(s);
					AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
					clip.open(audioStream);
				} catch (Exception e1) {e1.printStackTrace();}
			}
		}
	}

	class PlayAudio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clip1.start();
			clip1.addLineListener(new LineListener() {
				public void update(LineEvent e) {
					if (e.getType() == LineEvent.Type.STOP) {
						try {clip2.start();
							clip2.addLineListener(new LineListener() {
								public void update(LineEvent e) {
									if (e.getType() == LineEvent.Type.STOP) {
										try {
											clip3.start();
											clip3.addLineListener(new LineListener() {
												public void update(LineEvent e) {
													if (e.getType() == LineEvent.Type.STOP) {
														try {clip4.start();
														} catch (Exception e1) {e1.printStackTrace();}
			}}});} catch (Exception e1) {e1.printStackTrace();}
		}}});} catch (Exception e1) {e1.printStackTrace();}
	}}});}}
	class StopAudio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clip1.stop(); clip2.stop(); clip3.stop(); clip4.stop();
		}
	}
	public static void main(String[] args) {
		new no8();
	}
}
