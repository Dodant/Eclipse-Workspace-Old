public class Octagon {
	public static void draw(TurtleGraphics tg) {
		tg.penDown();
		for (int i = 0; i < 8; i++) {
			tg.forward(100);
			tg.leftTurn(45);
		}
	}
}
