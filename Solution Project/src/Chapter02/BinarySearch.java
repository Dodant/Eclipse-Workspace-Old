package Chapter02;
// 2.3 이진 탐색 
import java.util.Scanner;

public class BinarySearch {
	static int binarySearch(int[] a, int i, int j, int x) {
		if(i > j) return -1;
		int mid = (i+j)/2;
		if(x < a[mid]) return binarySearch(a, i, mid - 1, x);
		else if (x > a[mid]) return binarySearch(a, mid + 1, j, x);
		else return mid;
	}
	public static void main(String[] args) {
		int[] a = {2,3,5,7,11,13,17,19,23,31};
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number to search : ");
		int x = sc.nextInt();
		
		int k = binarySearch(a, 0, a.length - 1, x);
		if(k >= 0) System.out.println("at " + k);
		else System.out.println("Not Found");
	}
}
