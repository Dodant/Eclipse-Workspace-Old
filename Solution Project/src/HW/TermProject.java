package HW;

import java.util.Stack;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class TermProject {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		int numOfStdt, finalCounts;
		int[] student, count;
		Stack<Integer> stk;

		try {
			Scanner sc = new Scanner(new File("project_input.txt"));
			int testCase = sc.nextInt();

			for (int i = 0; i < testCase; i++) {
				numOfStdt = sc.nextInt();
				student = new int[numOfStdt];
				count = new int[numOfStdt];
				stk = new Stack<>();

				for (int j = 0; j < numOfStdt; j++) {
					student[j] = sc.nextInt() - 1;
					count[student[j]] += 1;
				}

				finalCounts = 0;
				for (int j = 0; j < numOfStdt; j++) if (count[j] == 0) stk.push(j);
				while (!stk.empty()) {
					int popedIndex = stk.pop();
					count[student[popedIndex]]--;
					if (count[student[popedIndex]] == 0) stk.push(student[popedIndex]);
				}
				for (int j = 0; j < numOfStdt; j++) if (count[j] == 0) finalCounts++;
				System.out.println(finalCounts);
			}

			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) + "ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

