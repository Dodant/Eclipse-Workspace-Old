import java.awt.*;
import javax.swing.*;

public class TurtleMain extends JFrame {
	// Turtle의 3가지 속성 : 위치(x,y), 터틀이 바라보는 방향, 팬의 속성
	// Pen up, Pen Down
	public static void main(String[] args) {
		JFrame frame = new TurtleMain();
		frame.setTitle("Turtle Graphics");
		frame.setSize(1200, 720);

		frame.getContentPane().add(new MyPanel());

		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	static class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			TurtleGraphics tg = new TurtleGraphics(600, 360, 0, g);
//			MyShell.draw(tg);
//	        Rectangle.draw(tg);		//사각형 
//	        Pentagon.draw(tg);		//오각형 
//	        Octagon.draw(tg);		//팔각형 
//	        Tree.draw(tg);			//트리 
//	        Polygon.draw(tg, 5, 12);
		}
	}
}
