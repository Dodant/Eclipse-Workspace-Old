package HW;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pillar {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		try {
			Scanner sc = new Scanner(new File("post_input.txt"));
			int testCase = sc.nextInt();
			for (int i = 0; i < testCase; i++) {
				int n = sc.nextInt();
				int l = sc.nextInt();
				int r = sc.nextInt();
				System.out.println(pillar(n, l, r));
			}
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) + "ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static long pillar(int n, int l, int r) {
		if (n == 0 || l == 0 || r == 0) return 0;
		if (n == 1 && l == 1 && r == 1) return 1;
		return pillar(n - 1, l - 1, r) + pillar(n - 1, l, r - 1) + (n - 2) * pillar(n - 1, l, r);
	}
}