package Chapter01;
// 1.5 데이터에서 득정 시퀸스 찾기	
import java.util.*;

public class SubListSearch {
	public static void main(String[] args) {
		Integer[] data = {1,2,3,4,5,2,3,5,7};
		List<Integer> list = new ArrayList<>(Arrays.asList(data));
		List<Integer> sublist = new ArrayList<>(); sublist.add(2); sublist.add(3);
		System.out.println(list);
		System.out.println(sublist);

		int first = Collections.indexOfSubList(list, sublist);
		int last = Collections.lastIndexOfSubList(list, sublist);
		
		System.out.println(first);
		System.out.println(last);	
	}
}
