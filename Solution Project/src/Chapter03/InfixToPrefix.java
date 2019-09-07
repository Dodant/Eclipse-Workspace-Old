package Chapter03;
// 3.3 스택의 응용 
// 3.2 수식의 계산 
import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
	public static String infixToPrefix(String in) {
		Stack<Character> stk = new Stack<>();
		StringBuffer post = new StringBuffer();

		for (char ch : in.toCharArray()) {
			if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z') {
				post.append(ch);
				continue;
			}
			if (ch == '*' || ch == '/') {
				while (!stk.empty() && (stk.peek() == '*' || stk.peek() == '/')) {
					post.append(stk.pop());
				}
				stk.push(ch);
			} else if (ch == '+' || ch == '-') {
				while (!stk.empty() && stk.peek() != '(') {
					post.append(stk.pop());
				}
				stk.push(ch);
			} else if (ch == '(') {
				stk.push(ch);
			} else if (ch == ')') {
				while (!stk.empty() && stk.peek() != '(') {
					post.append(stk.pop());
				}
				stk.pop();
			}
		}
		while (!stk.empty()) {
			post.append(stk.pop());
		}
		return post.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Infix expression : ");
		String infix = sc.nextLine();

		String postfix = infixToPrefix(infix);
		System.out.println("Postfix expression : " + postfix);
	}
}
