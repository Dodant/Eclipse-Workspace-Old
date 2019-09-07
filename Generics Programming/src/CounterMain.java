import java.util.Iterator;

public class CounterMain {
	public static void main(String[] args) {
		Counter c = new Counter(10);

		Iterator<Integer> iter = c.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}
