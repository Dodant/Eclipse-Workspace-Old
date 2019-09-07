package Chapter02;
// 2.5 피보나치 수의 계산 
import java.util.Scanner;

public class Fibonacci {
	static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number : ");
		int a = sc.nextInt();
		
		System.out.println(a + "번째 피보나치수 = " + fibonacci(a));
	}
}
