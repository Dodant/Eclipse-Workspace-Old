package Chapter02;
// 2.7 하노이탑  
import java.util.Scanner;

public class HanoiTower {
	public static void moveDisk(int n, char src, char inter, char dst) {
		if(n == 0) return;
		moveDisk(n-1, src, dst, inter);
		System.out.printf("Move disk %d from %c to %c.\n", n, src, dst);
		moveDisk(n-1, inter, src, dst);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input the number of disks : ");
		int n = sc.nextInt();
		moveDisk(n, 'A', 'B', 'C');
	}
}
