import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Box<Object> objBox = new Box<Object>(new Object());
		Box<String> strBox = new Box<String>("Hello");
		Box<Integer> intBox = new Box<Integer>(123);

//		ArrayList<String> arr = new ArrayList<String>();
//		Scanner scan = new Scanner(System.in);
//		for (int i = 0; i < 4; i++) {
//			String s = scan.next();
//			arr.add(s);
//		}
//		for (int i = 0; i < 4; i++) { System.out.println(i + " " + arr.get(i)); }
//		for (String s : arr) { System.out.println(s); }
		
//		arr.size();
//		arr.remove(2);
//		arr.contains("abc");
//		arr.isEmpty();
		
		//Collections가 제공하는 함수들 
//		Collections.sort(arr);
//		Collections.reverse(arr);
//		Collections.max(arr);
//		Collections.min(arr);
//		Collections.binarySearch(arr, "abc");
		
//		HashMap<String,String> dic = new HashMap<String,String>();
//		
//		dic.put("baby", "아기");
//		dic.put("love", "사랑");
//		dic.put("apple", "사과");
//		
//		String s1 = dic.get("baby");
//		String s2 = dic.get("university");
//		
//		Set<String> key_set = dic.keySet();
//		Iterator<String> it = key_set.iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			System.out.println(dic.get(key));
//		}
		
		printElem(objBox);
		printElem(strBox);
		printElem(intBox);
		
		getElem(objBox);
		getElem(strBox);
		getElem(intBox);

		putElem(objBox);
		putElem(strBox);
//		putElem(intBox);
		
		copy(objBox, strBox); // OK! 		T = Object,	? = String
		copy(objBox, intBox); // OK! 		T = Object, ? = String
//		copy(intBox, strBox); // 컴파일 에러	T = Integer,? = String,	? extends T = false
//	    copy(strBox, intBox); // 컴파일 에러	T = String, ? = Integer,? extends T = false
//		copy(strBox, objBox); // 컴파일 에러	T = String, ? = Object, ? extends T = false
//	    copy(intBox, objBox); // 컴파일 에러	T = Integer,? = Object, ? extends T = false
		Main.copy(objBox, intBox); 			// T = Integer, ?1 = Object, ?2 = Integer
											// ?1 super T = true, ?2 extends T = true
		Main.<Object>copy(objBox, intBox);	
		Main.<Integer>copy(objBox, intBox);
		Main.<Number>copy(objBox, intBox);	// T = Number, ?1 = Object, ?2 = Integer
											// ?1 super T = true, ?2 extends T = true				

	}
	public static void printElem(Box<?> box) {
		Object obj = box.get();
		System.out.println(obj.toString());
	}
	public static Object getElem(Box<?> box) {
		return box.get();
	}
	public static void putElem(Box<? super String> box) {
		box.put("halo");
	}
	public static <T> void writeElem(Box<? super T> box, T s) {
		box.put(s);
	}
	public static <T> void copy(Box<? super T> dst, Box<? extends T> src) {	// Focus!! - 가장 일반적인 케이스 
		dst.put(src.get());
	}
}
