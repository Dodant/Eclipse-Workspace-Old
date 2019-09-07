package HW;
import java.util.Scanner;

public class DoubleNTriple {
	public static int doubleNtriple(int i){
		if(i == 1) {
			System.out.println(i + "\nDone"); 
			return -1;
		} else {
			System.out.println(i);
			return doubleNtriple((i%2==1)?3*i+1:i/2);
		} 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Number: ");
		int n = sc.nextInt();
		doubleNtriple(n);
	}
}

//import java.util.Scanner;
//
//public class DoubleNTriple {
//	public static int count = 1;
//	public static int doubleNtriple(int i){
//		if(i == 1) {
//			System.out.println(count);
//			return count;
//		} else if (i%2 == 1){
//			count++;
//			return doubleNtriple(3*i+1);
//		} else {
//			count++;
//			return doubleNtriple(i/2);
//		}
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		doubleNtriple(n);
//	}
//}
