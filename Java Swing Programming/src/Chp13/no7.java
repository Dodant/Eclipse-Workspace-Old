package Chp13;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class no7 extends JFrame {
	private Thread snakeThread;
	private Ground p;
	public no7() {
		super("Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new Ground();
		setContentPane(p);
		setSize(400,400);
		setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
		
		snakeThread = new Thread(p);
		snakeThread.start();
	}

	class Ground extends JPanel implements Runnable{
		private static final int LEFT = 0;
		private static final int RIGHT = 1;
		private static final int UP = 2;
		private static final int DOWN = 3;
		private int direction;
		private SnakeBody snakeBody;
		
		public Ground() {
			setLayout(null);
			snakeBody = new SnakeBody();
			snakeBody.addIn(this);
			direction = RIGHT;
			this.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					switch(e.getKeyCode()) {
					case KeyEvent.VK_LEFT:
						direction = LEFT; break;
					case KeyEvent.VK_RIGHT:
						direction = RIGHT; break;
					case KeyEvent.VK_UP:
						direction = UP; break;
					case KeyEvent.VK_DOWN:
						direction = DOWN; break;
					}
				}
			});
		}
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(200);				
					snakeBody.move(direction);
				}catch(InterruptedException e) {return;}
			}
		}
	}

	class SnakeBody {
		private Vector<JLabel> v = new Vector<JLabel>();
		
		public SnakeBody() {
			JLabel la = new JLabel("@");
			la.setSize(12, 12);
			la.setLocation(100, 100);
			v.add(la);
	
			for(int i = 1; i < 10; i++) {
				la = new JLabel("#");
				la.setSize(10, 10);
				la.setLocation(100+i*20, 100);
				v.add(la);
			}
		}
		public void addIn(JPanel p) {
			for(int i = 0; i < v.size(); i++) p.add(v.get(i));
		}
		public void move(int direction) {
			for(int i = v.size()-1; i > 0; i--) {
				JLabel b = v.get(i);
				JLabel a = v.get(i-1);
				b.setLocation(a.getX(), a.getY());
			}
			JLabel head = v.get(0);
			switch(direction) {
			case Ground.LEFT :
				head.setLocation(head.getX()-15, head.getY());
				break;
			case Ground.RIGHT :
				head.setLocation(head.getX()+15, head.getY());
				break;
			case Ground.UP :
				head.setLocation(head.getX(), head.getY()-15);
				break;
			case Ground.DOWN :
				head.setLocation(head.getX(), head.getY()+15);
				break;
			}
		} 
	}
	public static void main(String[] args) {
		new no7();
	}
}
