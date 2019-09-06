package Chp13;
import java.awt.*;
import javax.swing.*;

class LabelRunnable implements Runnable {
	private JLabel VibLabel;
	
	public LabelRunnable(JLabel VibLabel) {
		this.VibLabel = VibLabel;
	}
	@Override
	public void run() {
		while(true) {
			VibLabel.setLocation(20 + (int)(Math.random()*5), 40 + (int)(Math.random()*5));
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException e) {return;}
		}
	}
}

public class no4 extends JFrame {
	public no4() {
		setTitle("Vibrate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel lb = new JLabel("진동레이블");
		LabelRunnable runnable = new LabelRunnable(lb);
		Thread th = new Thread(runnable);
		th.start();
		
		c.add(lb);
		setSize(250,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new no4();
	}
}