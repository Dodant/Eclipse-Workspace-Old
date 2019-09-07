package Chapter02;
// 2.6 Ackermann 함수 계산  
import java.util.Scanner;

public class Ackermann {
	static int ackermann(int m, int n) {
		if(m == 0) return n+1;
		if(n == 0) return ackermann(m-1, 1);
		return ackermann(m-1, ackermann(m, n-1));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(ackermann(a, b));
	}
}
