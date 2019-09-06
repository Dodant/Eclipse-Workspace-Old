import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		CalcEngine engine = new CalcEngine();
		
		Window w1 = new Window();
		Window w2 = new Window(100, 200, 640, 320);
		Window w3 = new Window(300,300,70,70);
		
		Button b0 = new Button("0");
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");
		Button b4 = new Button("4");
		Button b5 = new Button("5");
		Button b6 = new Button("6");
		Button b7 = new Button("7");
		Button b8 = new Button("8");
		Button b9 = new Button("9");
		Button bplus = new Button("+");
		Button bminus = new Button("-");
		Button bmulti = new Button("*");
		Button bdiv = new Button("/");
		Button bequal = new Button("=");
		Button breset = new Button("C");
		
		ButtonClickListener handler = new ButtonClickListener() {
			@Override
			public void onClick(Button b) {
				System.out.println(b.getText() + " << User Input");
			}
		};
		
		b0.setHandler(handler);
		b1.setHandler(handler);
		b2.setHandler(handler);
		b3.setHandler(handler);
		b4.setHandler(handler);
		b5.setHandler(handler);
		b6.setHandler(handler);
		b7.setHandler(handler);
		b8.setHandler(handler);
		b9.setHandler(handler);
		bplus.setHandler(handler);
		bminus.setHandler(handler);
		bmulti.setHandler(handler);
		bdiv.setHandler(handler);
		bequal.setHandler(handler);
		breset.setHandler(handler);
		
		Button[] arr = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, 
				bplus, bminus, bmulti, bdiv, bequal, breset};
		
		Text textWin = new Text("0");
		
		engine.initialize();
		engine.enter("0");
		System.out.println("Text Window: " + textWin.getText());
		
		while(true) {
			Scanner scan = new Scanner(System.in);
			String buttonName = scan.nextLine();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].getText().equals(buttonName)) {						
					arr[i].getHandler().onClick(arr[i]);
					engine.enter(buttonName);									//버튼 이름을 입력 
					textWin.setText(engine.getDisplay());						//d를 text윈도우에 설정 
					System.out.println("Text Window: " + textWin.getText());	//text윈도우의 내용을 출력 
				}
			}
		}
	}
}
