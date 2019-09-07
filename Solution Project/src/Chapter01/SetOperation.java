package Chapter01;
// 1.3 집합연산 
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class SetOperation {

	public static <T> Set<T> union(Set<T> a, Set<T> b){			// 합집합 
		Set<T> tmp = new TreeSet<>(a);
		tmp.addAll(b);
		return tmp;
	}
	public static <T> Set<T> intersection(Set<T> a, Set<T> b){	// 교집합 
		Set<T> tmp = new TreeSet<>(a);
		tmp.retainAll(b);
		return tmp;
	}
	public static <T> Set<T> difference(Set<T> a, Set<T> b){	// 차집합 
		Set<T> tmp = new TreeSet<>(a);
		tmp.removeAll(b);
		return tmp;
	}
	public static <T> Boolean isSubset(Set<T> a, Set<T> b){
		return b.containsAll(a);
	}
	public static <T> Boolean isSuperset(Set<T> a, Set<T> b){
		return a.containsAll(b);
	}
	public static void main(String[] args) {
		Character[] aData = {'A', 'B', 'C', 'D'};
		Character[] bData = {'F', 'E', 'D', 'C'};
		Set<Character> a = new TreeSet<>(Arrays.asList(aData));
		Set<Character> b = new TreeSet<>(Arrays.asList(bData));
		Set<Character> c = new TreeSet<>(a); c.remove('C'); c.remove('D');
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		System.out.println(union(a,b));
		System.out.println(intersection(a, b));
		System.out.println(difference(a, b));
		
		System.out.println("Is a subset of c? " + isSubset(a,c));
		System.out.println("Is a superset of c? " + isSuperset(a,c));
		System.out.println("Is c subset of a? " + isSubset(c,a));
		System.out.println("Is c superset of a? " + isSuperset(c,a));
		
		System.out.println("Are a and c disjoint? " + Collections.disjoint(a, c));	// disjoint - 공통원소를 갖지 않은 
		System.out.println("Are b and c disjoint? " + Collections.disjoint(b, c));
	}
}
