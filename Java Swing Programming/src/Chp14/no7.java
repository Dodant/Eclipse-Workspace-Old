package Chp14;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class no7 extends JFrame{
	private JLabel statelb = new JLabel("오디오 파일을 선택하세요.");
	private Clip clip;
	private AudioInputStream audioStream;
	String filepath, filename;
	
	public no7() {
		JMenuBar mb = new JMenuBar();
		JMenu audio = new JMenu("Audio");
		JMenuItem play = new JMenuItem("Play");
		JMenuItem stop = new JMenuItem("stop");
		play.addActionListener(new PlayActionListener());
		stop.addActionListener(new PlayActionListener());
		
		audio.add(play);
		audio.add(stop);
		mb.add(audio);
		setJMenuBar(mb);
		
		getContentPane().add(statelb, BorderLayout.CENTER);
		setTitle("오디오 파일을 찾아 연주/종료 제어");
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	class PlayActionListener implements ActionListener {
		private JFileChooser chooser;
		public PlayActionListener() {
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "Play") {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("AudioFile(wav,mid,rmf)", "wav", "rmf");
				chooser.setFileFilter(filter);
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
				filepath = chooser.getSelectedFile().getPath();
				filename = chooser.getSelectedFile().getName();
				statelb.setText(filename + "를 연주하고 있습니다.");
				loadAudio(filepath);
			} else if (e.getActionCommand() == "Stop") {
				clip.stop();
				statelb.setText("연주를 중단했습니다.");				
			}
		}
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
		new no7();
	}
}
