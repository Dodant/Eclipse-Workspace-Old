package Chapter03;
// 3.1 스택의 개념 
class Stack<E> {
	final static int SIZE = 100;
	E[] elements;
	int top;
	
	Stack(){
		elements = (E[])new Object[100];
		top = -1;
	}
	void push(E e) {
		if(top >= SIZE - 1) {
			throw new ArrayIndexOutOfBoundsException("Stack is full");
		}
		elements[++top] = e;
	}
	E pop() {
		if(top < 0) {
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}
		return elements[top--];
	}
	E peek() {
		if(top < 0) {
			throw new ArrayIndexOutOfBoundsException("Stack is empty");
		}
		return elements[top];
	}
}

public class SimpleStack {
	public static void main(String[] args) {
		Stack<Character> s = new Stack<>();
		
		System.out.print("Push A, B ... \t");
		s.push('A');
		s.push('B');
		System.out.println("Top element is " + s.peek());
		
		System.out.print("Push C ... \t");
		s.push('C');
		System.out.println("Top element is " + s.peek());
		
		System.out.print("Push D ... \t");
		s.push('D');
		System.out.println("Top element is " + s.peek());
		
		System.out.print("Pop ... \t");
		s.pop();
		System.out.println("Top element is " + s.peek());
	}
}
