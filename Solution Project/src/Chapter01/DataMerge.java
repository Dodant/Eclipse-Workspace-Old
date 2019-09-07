package Chapter01;
// 1.2 중복된 데이터 없애기 
import java.util.*;

public class DataMerge {

	public static <T> Collection<T> merge(Collection<T> a, Collection<T> b){
		Set<T> set = new LinkedHashSet<>();
		set.addAll(a);
		set.addAll(b);
		return set;
	}

	public static void main(String[] args) {
		Integer[] a = {3,5,7,2,7,9,2};
		Integer[] b = {4,7,2,9,8,7};
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(merge(Arrays.asList(a), Arrays.asList(b)));
		
		String[] c = {"to", "be", "or", "not", "to", "be"};
		String[] d = {"to", "have", "or", "to", "be"};
		
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		
		System.out.println(merge(Arrays.asList(c), Arrays.asList(d)));
	}

}
