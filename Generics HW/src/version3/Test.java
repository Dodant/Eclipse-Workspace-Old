package version3;

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
		
		List<Fruit> mixed = Arrays.<Fruit>asList(a1,o3);
		System.out.println(Collections.max(mixed, new MixedComparator()));
	}	
}
/*
*** MixedComparator 클래스를 작성한 방법에 대한 아이디어를 간단히 서술

import java.util.Comparator;
public class MixedComparator implements Comparator<Fruit>{
	@Override
	public int compare(Fruit f1, Fruit f2) {
		return f1.compareTo(f2);
	}
	@Override
	public boolean equals(Object obj) {
		Fruit test1 = new Fruit("test",1);
		Fruit test2 = new Fruit("test",2);
		if(obj instanceof Comparator)
			return ((Comparator) obj).compare(test1, test2) == this.compare(test1, test2);
		else
			return false;
	}
}

이 예제에서는 compare 메소드만 구현해도 되지만 equals도 같이 구현해 보았다.
Fruit 와 그 후손 클래스들에게만 적용되는 Comparator로 Fruit 클래스에 구현되어 있는
compareTo 메소드를 호출해서 비교한다.
equals 메소드는 api를 읽어보니 같은 java.util.Comparator인터페이스를 포함한 객체이면서
모든 객체에 대해 compare 메소드가 같은 값을 리턴할 때만 true를 리턴하라고 나와있다.
먼저 instanceof 연산자로 Comparator 인터페이스를 구현한지 확인하고
구현했다면 생선된 테스트용 Fruit 객체를 compare 한 결과가 같은지를 확인한다.

*/