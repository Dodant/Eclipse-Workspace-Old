package HW;

import java.util.ArrayList;
import java.util.Scanner;

public class Hello {
	static ArrayList<Integer> prime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] primeNum = new int[1001];
		primeNum[1] = -1;
		prime = new ArrayList<>();

		// 에라토스테네스의 체
		for (int i = 2; i <= 1000; i++) {
			if (primeNum[i] != -1) { // 소수일때
				prime.add(i);
				int a = 1;
				while (true) {
					a++;
					if (i * a >= 1000)
						break;
					primeNum[i * a] = -1;
				}
			} else {
				continue;
			}
		}

		System.out.println(prime.size());
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			Result(k);
		}
	}

	public static void Result(int k) {
		for (int a = 0; a < prime.size(); a++) {
			for (int b = 0; b < prime.size(); b++) {
				for (int c = 0; c < prime.size(); c++) {
					if (k == (prime.get(a) + prime.get(b) + prime.get(c))) {
						System.out.println(prime.get(a) + " + " + prime.get(b) + " + " + prime.get(c));
						return;
					}
				}
			}
		}
		System.out.println(0);
		return;
	}
}