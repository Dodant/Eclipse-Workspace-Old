package Chapter03;
// 3.3 스택의 응용
// 3.1 수식의 괄호 검사 
import java.util.Scanner;
import java.util.Stack;

public class ParenCheck {
	private Stack<Character> stk;
	public ParenCheck() {
		stk = new Stack<>();
	}
	public boolean check(String str) {
		for(char ch : str.toCharArray()) {
			if(ch == '(') stk.push(')');
			if(ch == '{') stk.push('}');
			if(ch == ')' || ch == '}') {
				if(stk.empty() || ch != stk.pop()) return false;
			}
		}
		if(!stk.empty()) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Expression : ");
		String str = sc.nextLine();
		
		ParenCheck checker = new ParenCheck();
		if(checker.check(str)) System.out.println("Balanced Expression");
		else System.out.println("Unbalanced Expression");
	}
}
