package Chp14;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class no5 extends JFrame{
	private Clip clip;
	private AudioInputStream audioStream;
	
	public no5() {
		JLabel lb = new JLabel();
		loadAudio("hiphop.wav");
		getContentPane().addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				lb.setText("연주 일시 중단");
				clip.stop();
			}
			public void mouseEntered(MouseEvent e) {
				lb.setText("연주 계속");
				clip.start();
			}
		});
		add(lb, BorderLayout.CENTER);
		setTitle("오디오 시작 중단 연습");
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void loadAudio(String pathname) {
		try {
			File audioFile = new File(pathname);
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		} 
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (UnsupportedAudioFileException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	public static void main(String[] args) {
		new no5();
	}
}
