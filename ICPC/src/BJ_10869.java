import java.util.Scanner;
//10869, 10430
public class BJ_10869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int t = 0;
		for(int i = 1; i <= a; i++) {
			t += i;
		}
		System.out.println(t);
	}
}
