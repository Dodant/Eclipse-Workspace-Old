package Chapter03;
// 3.5 덱
import java.util.*;

public class TestDeque {
	public static void main(String[] args) {
		Deque<String> dq = new ArrayDeque<String>();
		dq.addFirst("Earth");
		dq.addFirst("Venus");
		dq.addFirst("Mercury");
		dq.addLast("Mars");
		dq.addLast("Jupiter");
		dq.addLast("Saturn");
		dq.addLast("Uranus");
		dq.addLast("Neptune");
		dq.addFirst("Sun");
		
		for (String planet : dq) {
			System.out.println(planet);
		}
	}

}
