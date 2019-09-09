public class Pentagon {
	public static void draw(TurtleGraphics tg) {
		tg.penDown();
		tg.rightTurn(90);
		for(int i = 0; i < 5; i++) {
			tg.forward(100);
			tg.leftTurn(72);
		}
	}
}
