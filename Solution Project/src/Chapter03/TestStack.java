package Chapter03;
// 3.1 스택의 개념 
import java.util.Stack;

public class TestStack {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		
		System.out.print("Pushing 3 ... \t");
		s.push(3);
		System.out.println("Top element is " + s.peek());
		
		System.out.print("Pushing 6 ... \t");
		s.push(6);
		System.out.println("Top element is " + s.peek());
		
		System.out.print("Pushing 9 ... \t");
		s.push(9);
		System.out.println("Top element is " + s.peek());
		
		System.out.println("Stack size is " + s.size());

		while(!s.empty()) {
			int e = s.pop();
			System.out.println("Poped element is " + e);
		}
	}
}
