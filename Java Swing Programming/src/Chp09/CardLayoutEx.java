package Chp09;
import java.awt.*;
import javax.swing.*;

public class CardLayoutEx extends JFrame {

	Container container = getContentPane();
	CardLayout card = new CardLayout();

	public CardLayoutEx() {
		
		setLayout(card);
		setTitle("CARD Demo");

		Box box1 = Box.createHorizontalBox();
		box1.add(new JButton("A"));
		box1.add(new JButton("B"));
		box1.add(new JButton("C"));
		
		Box box2 = Box.createHorizontalBox();
		box2.add(new JButton("1"));
		box2.add(new JButton("2"));
		
		container.add(box1, "Card1");
		container.add(box2, "Card2");
		
		setSize(275, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		while (true) {
			card.next(container);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		new CardLayoutEx();
	}
}
