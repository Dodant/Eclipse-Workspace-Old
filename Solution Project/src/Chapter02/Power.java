package Chapter02;
// 2.2 지수 승 계산 
import java.util.Scanner;

public class Power {
	static int power(int a, int b) {
		if(b == 0) return 1;
		return a * power(a, b-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a and b : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a + "^" + b + " is " + power(a, b));
	}
}
