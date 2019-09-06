
public class Text extends Window {
	private String text;
	
	public Text(String text) {
		this.text = text;
	}
	@Override
	public void draw() {
		System.out.print("Text =" + text + " ");
		super.draw();
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
