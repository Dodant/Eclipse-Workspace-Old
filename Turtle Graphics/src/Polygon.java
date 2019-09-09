public class Polygon {
	public static void draw(TurtleGraphics tg, int n, int r) {
		double p = 2 * r * Math.sin(Math.toRadians(180.0 / n));
		tg.penDown();
		for (int i = 1; i <= n; i++) {
			tg.forward(p);
			tg.leftTurn(360.0 / n);
		}
		tg.penUp();
	}
}