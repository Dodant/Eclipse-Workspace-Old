
public class CalcEngine extends Window{
	
	int n1, n2 = 0;
	int display;
	String op = "";
	
	public void initialize() {
		n1 = 0;
		display = 0;
	}
	public String getDisplay() {
		return Integer.toString(display);
	}
	public void enter(String input) {
		if(input.equals("C")) {
			n1 = n2 = display = 0;
			op = "";
		} else if(op.contains("+")){
			if(!input.equals("=")) {
				if(input.equals("+")) {
					flag();
					n1 = n1 + n2;
					n2 = 0;
					op = "+" + n2;
					display = n1;
				} else if (input.equals("-")) {
					flag();
					n1 = n1 + n2;
					n2 = 0;
					op = "-" + n2;
					display = n1;
				}else if (input.equals("*")) {
					flag();
					n1 = n1 + n2;
					n2 = 0;
					op = "*" + n2;
					display = n1;
				}else if (input.equals("/")) {
					flag();
					n1 = n1 + n2;
					n2 = 0;
					op = "/" + n2;
					display = n1;
				} else {
					n2 = n2 * 10 + Integer.parseInt(input);
					display = n2;
					op = "+" + n2;
				}
			} else {
				flag();
				op = "";
				n1 = n2 = 0;
			}
				
		} else if(op.contains("-")){
			if(!input.equals("=")) {
				if(input.equals("+")) {
					flag();
					n1 = n1 - n2;
					n2 = 0;
					op = "+" + n2;
					display = n1;
				} else if (input.equals("-")) {
					flag();
					n1 = n1 - n2;
					n2 = 0;
					op = "-" + n2;
					display = n1;
				}else if (input.equals("*")) {
					flag();
					n1 = n1 - n2;
					n2 = 0;
					op = "*" + n2;
					display = n1;
				}else if (input.equals("/")) {
					flag();
					n1 = n1 - n2;
					n2 = 0;
					op = "/" + n2;
					display = n1;
				} else {
					n2 = n2 * 10 + Integer.parseInt(input);
					display = n2;
					op = "-" + n2;
				}
			} else {
				flag();
				op = "";
				n1 = n2 = 0;
			}
		} else if(op.contains("*")){
			if(!input.equals("=")) {
				if(input.equals("+")) {
					flag();
					n1 = n1 * n2;
					n2 = 0;
					op = "+" + n2;
					display = n1;
				} else if (input.equals("-")) {
					flag();
					n1 = n1 * n2;
					n2 = 0;
					op = "-" + n2;
					display = n1;
				}else if (input.equals("*")) {
					flag();
					n1 = n1 * n2;
					n2 = 0;
					op = "*" + n2;
					display = n1;
				}else if (input.equals("/")) {
					flag();
					n1 = n1 * n2;
					n2 = 0;
					op = "/" + n2;
					display = n1;
				} else {
					n2 = n2 * 10 + Integer.parseInt(input);
					display = n2;
					op = "*" + n2;
				}
			} else {
				flag();
				op = "";
				n1 = n2 = 0;
			}
		} else if(op.contains("/")){
			if(!input.equals("=")) {
				if(input.equals("+")) {
					flag();
					n1 = n1 / n2;
					n2 = 0;
					op = "+" + n2;
					display = n1;
				} else if (input.equals("-")) {
					flag();
					n1 = n1 / n2;
					n2 = 0;
					op = "-" + n2;
					display = n1;
				}else if (input.equals("*")) {
					flag();
					n1 = n1 / n2;
					n2 = 0;
					op = "*" + n2;
					display = n1;
				}else if (input.equals("/")) {
					flag();
					n1 = n1 / n2;
					n2 = 0;
					op = "/" + n2;
					display = n1;
				} else {
					n2 = n2 * 10 + Integer.parseInt(input);
					display = n2;
					op = "/" + n2;
				}
			} else {
				flag();
				op = "";
				n1 = n2 = 0;
			}
		} else if(Character.isDigit(input.charAt(0))){
			n1 = n1 * 10 + Integer.parseInt(input);
			display = n1;
			op = "";
		} else if(input.equals("+")) {
			op = "+" + n2;
			display = n1;
		} else if(input.equals("-")) {
			op = "-" + n2;
			display = n1;
		} else if(input.equals("*")) {
			op = "*" + n2;
			display = n1;
		} else if(input.equals("/")) {
			op = "/" + n2;
			display = n1;
		} else if(input.equals("=")) {
			flag();
		} 
		System.out.println("Calc Engine State: " + n1 + op + ", " + display);
		if ((op == "") && (n1 == 0) && (display != 0)) n1 = display;
	}
	public void flag() {
		if(op.contains("+")) {
			display = n1 + n2;
		} else if(op.contains("-")) {
			display = n1 - n2;
		} else if(op.contains("*")) {
			display = n1 * n2;
		} else if(op.contains("/")) {
			display = n1 / n2;
		}
	}
}
