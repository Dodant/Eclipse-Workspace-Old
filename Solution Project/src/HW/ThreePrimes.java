package HW;
import java.io.*;
import java.util.*;

public class ThreePrimes {
	public static void main(String[] args) {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		NEXT: for (int i = 3; i <= 1000; i += 2) {
			for (int k : primes) if (i % k == 0) continue NEXT;
			primes.add(i);
		}

		try {
			Scanner sc = new Scanner(new File("Prime_input.txt"));
			int T = sc.nextInt();
			long startTime = System.currentTimeMillis();
			HOPE: for (int k = 0; k < T; k++) {
				int num = sc.nextInt();
				for (int a : primes) {
					for (int b : primes) {
						for (int c : primes) {
							if (a + b + c == num) {
								System.out.println(a + " " + b + " " + c);
								continue HOPE;
			}}}}}
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) + "ms");
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
//
//import java.io.*;
//import java.util.*;
//
//public class Main {
//	public static void main(String[] args) {
//		List<Integer> primes = new ArrayList<>();
//		primes.add(2);
//		NEXT: for (int i = 3; i <= 1000; i++) {
//			for (int k : primes) if (i % k == 0) continue NEXT;
//			primes.add(i);
//		}
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		HOPE: for (int k = 0; k < T; k++) {
//			int num = sc.nextInt();
//			for (int a : primes) {
//				for (int b : primes) {
//					for (int c : primes) {
//						if (a + b + c == num) {
//							System.out.println(a + " " + b + " " + c);
//							continue HOPE;
//		}}}}}
//		sc.close();
//	}
//}