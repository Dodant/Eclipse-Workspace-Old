package Chapter02;
// 2.4 계승 (Factorial) 
import java.util.Scanner;

public class Factorial {
	static int factorial(int n) {
		if(n == 0) return 1;
		return n * factorial(n-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number : ");
		int a = sc.nextInt();
		System.out.println(a + "! = " + factorial(a));
	}
}
