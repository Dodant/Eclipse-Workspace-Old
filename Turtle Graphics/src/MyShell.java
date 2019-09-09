
public class MyShell {
	public static void draw(TurtleGraphics tg) {
		tg.rightTurn(90);
		for(int i = 5; i < 100; i++) {
			Polygon.draw(tg, i, (100 + i * 2) / 3);
			tg.leftTurn(5);
		}
		tg.penUp();
	}
}
