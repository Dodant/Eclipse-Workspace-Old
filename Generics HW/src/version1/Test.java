package version1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Permitting comparison of apples with oranges
public class Test {
	public static void main(String[] args) {
		Apple a1 = new Apple(1); 
		Apple a2 = new Apple(2);
		Orange o3 = new Orange(3);
		Orange o4 = new Orange(4);
		
		List<Apple> apples = Arrays.asList(a1, a2);
		System.out.println(Collections.max(apples));
		
		List<Orange> oranges = Arrays.asList(o3, o4);
		System.out.println(Collections.max(oranges));
		
		List<Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
		System.out.println(Collections.max(mixed));			// OK
	}
}
/*
Fruit 클래스에 Comparable<Fruit> 인터페이스가 포함되어 있다.
Collections 클래스에 정의되어 있는 max 메소드 중
public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) ;
으로 정의된 max 메소드를 호출해서 비교할 수 있다.
T = Fruit ?1 = Fruit ?2 = Fruit 으로 max가 호출되어 
a1과 o3를 비교하며 둘다 Fruit으로 업캐스팅 되어 비교된 후 Fruit로 리턴되어 출력된다. 
그래서 22번 라인은 OK다.
*/