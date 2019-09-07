package Chapter01;
// 1.1 소수 구하기 
import java.util.*;

public class PrimeNumber {

	public static List<Integer> getPrimeNumber(int k){
		List<Integer> primes = new ArrayList<>();
		if(k < 2) {
			return primes;
		}
		primes.add(2);
		
		Next_Number:
		for(int n = 3; n <= k; n += 2) {
			for(int i : primes) {
				if(n % i == 0)
					continue Next_Number;
			}
			primes.add(n);
		}
		return primes;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a number for K : ");
		int k = sc.nextInt();
		
		List<Integer> primes = getPrimeNumber(k);
		System.out.println(primes.size() + " / " + primes);
	}

}
