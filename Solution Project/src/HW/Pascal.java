package HW;

public class Pascal {

	public static void main(String[] args) {
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {				
				System.out.print(pascal(i,j) + " ");
			}
			System.out.println();
		}
	}
	public static int pascal(int n, int k) {	// Recursive - Top Down
		if(k == 1) return 1;
		if(n == k) return 1;
		return pascal(n-1, k-1) + pascal(n-1, k); 	
	}
	// DP - Bottom Up
}
