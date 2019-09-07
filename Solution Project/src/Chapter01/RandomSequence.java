package Chapter01;
// 1.2 중복된 데이터 없애기 
import java.util.*;

public class RandomSequence {
	public static Set<Integer> randomSequence(int a, int b, int k){
		Set<Integer> seq = new HashSet<>();
		Random rand = new Random();
		while(seq.size() < k) {
			int r = a + rand.nextInt(b - a + 1);
			seq.add(r);
		}
		return seq;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a, b, and k : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		
		Set<Integer> seq = randomSequence(a, b, k);
		System.out.println(seq + " / max is " + Collections.max(seq) + ", min is " + Collections.min(seq));
	}
}
