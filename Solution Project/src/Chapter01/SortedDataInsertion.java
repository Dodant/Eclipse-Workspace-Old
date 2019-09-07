package Chapter01;
// 1.4 정렬된 데이터에 새로운 값 추가하기 
import java.util.*;

public class SortedDataInsertion {

	public static void main(String[] args) {
		Integer[] data = {3,6,9,3,8,5,2,4,8};
		System.out.println(Arrays.toString(data));
		
		List<Integer> list = new LinkedList<>(Arrays.asList(data));
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		int[] newData = {5,7,0,10};
		for(int k : newData) {
			int i = Collections.binarySearch(list, k);
			if(i >= 0) 	System.out.printf("%d is found at %d. It will be inserted at %d\n", k, i, i+1);
			else 		System.out.printf("%d is not found. It will be inserted at %d\n", k, -(i+1));
			list.add(i>=0 ? i+1 : -(i+1), k);
			System.out.println("after adding " + k + " : " + list);
		}
	}
}
