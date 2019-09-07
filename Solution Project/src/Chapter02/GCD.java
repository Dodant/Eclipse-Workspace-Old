package Chapter02;
// 2.1 최대공약수 GCD 계산 
import java.util.Scanner;

public class GCD {
	static int getGCD(int a, int b) {
		if(b == 0) return a;
		return getGCD(b, a % b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a and b : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("The GCD of " + a + " and " + b + "is " + getGCD(a, b));
	}
}
