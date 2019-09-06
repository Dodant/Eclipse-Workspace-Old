
public class Button extends Window {
	private String text;
	private ButtonClickListener handler;

	public void setHandler(ButtonClickListener handler) {
		this.handler = handler;
	}
	public ButtonClickListener getHandler() {
		return handler;
	}
	public Button(String text) {
		this.text = text;
	}
	@Override
	public void draw() {
		System.out.print("Button = " + text + " ");
		super.draw();
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
