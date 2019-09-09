
public class Rectangle {

	public static void draw(TurtleGraphics tg) {
        tg.penDown();
        for(int i = 0; i < 4; i++) {
        	tg.forward(100);
        	tg.leftTurn(90);
        }
	}
}
