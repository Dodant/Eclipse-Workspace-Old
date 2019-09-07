package version2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
		
		List<? extends Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
//		System.out.println(Collections.max(mixed));			// compile-time error
	}
}
/*
22번째 라인이 compile-time error가 나는 이유는 Collections 클래스에 정의된 max 메소드 중에서
public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll);
로 정의된 max 함수를 호출했는데 
<T extends Comparable<? super T>> 를 만족하는 타입인자를 주지 못하기 때문이다. 
Fruit에는 Comparable 인터페이스가 구현되어 있지 않다.
*/