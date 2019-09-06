package Chp13;
import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

class TimerRunnable extends Thread {
	private JLabel ClockLabel;
	
	public TimerRunnable(JLabel clockLabel) {
		this.ClockLabel = clockLabel;
	}
	@Override
	public void run() {
		while(true) {
			Calendar c = Calendar.getInstance();
			int hr = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int sec = c.get(Calendar.SECOND);
			
			String clock = Integer.toString(hr);
			clock = clock.concat(":");
			clock = clock.concat(Integer.toString(min));
			clock = clock.concat(":");
			clock = clock.concat(Integer.toString(sec));
			
			ClockLabel.setText(clock);
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {return;}
		}
	}
}

public class no3 extends JFrame {
	public no3() {
		setTitle("Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel clockLabel = new JLabel();
		clockLabel.setFont(new Font("Gothic", Font.ITALIC, 40));
		c.add(clockLabel);
		
		TimerRunnable runnable = new TimerRunnable(clockLabel);
		runnable.start();
			
		setSize(250,150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new no3();
	}
}