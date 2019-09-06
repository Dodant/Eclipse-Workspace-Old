public class Window {
	private int x, y, w, h;
	private static int numberOfWindows = 0;
	private int id;

	public Window(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		id = numberOfWindows;
		numberOfWindows++;
	}
	public Window() {
		this(0,0,20,20); 
	}
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void resize(int w, int h) {
		this.w = w;
		this.h = h;
	}
	public void draw() {
		System.out.println( "id = " + id + " x = " + x + " y = " + y +
							" width = " + w + " height = " + h);
	}
}
