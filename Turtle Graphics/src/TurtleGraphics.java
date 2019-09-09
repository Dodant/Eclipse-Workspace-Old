import java.awt.Color;
import java.awt.Graphics;

public class TurtleGraphics {
	private double x; // 터틀의 위치
	private double y;
	private double degree; // 터틀의 방향 0~360도
	private boolean penup; // true이면 이동, false이면 그리기
	private Graphics g;
	private Color color;

	TurtleGraphics(double x, double y, double degree, Graphics g) {
		this.x = x;
		this.y = y;
		this.degree = degree;
		this.g = g;
		penup = true;
	}

	public void penUp() {penup = true;}
	public void penDown() {penup = false;}
	public void forward(double steps) {
		double currentX = x;
		double currentY = y;
		
		x += steps * Math.sin(degree * Math.PI / 180);
		y -= steps * Math.cos(degree * Math.PI / 180);
		
		if(penup == false) g.drawLine((int)currentX, (int)currentY, (int)x, (int)y);
	}
	public void backward(double steps) {forward(-steps);}
	public void leftTurn(double angle) {degree -= angle;}
	public void rightTurn(double angle) {degree += angle;}
	public double getX() {return x;}
	public double getY() {return y;}
	public double getDegree() {return degree;}
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
	public void setDegree(double degree) {this.degree = degree;}
	public void setColor(Color color) {this.color = color;}
}