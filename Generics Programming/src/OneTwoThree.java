import java.util.Iterator;

public class OneTwoThree implements Iterable<Integer> {
	private int one, two, three;
	public OneTwoThree(int one, int two, int three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	public Iterator<Integer> iterator() { return new MyIterator(); }
	
	class MyIterator implements Iterator<Integer> {
		private int index;
		public MyIterator() { index = 1; }
		public boolean hasNext() { return index < 4; }
		public Integer next() {
			if (index == 1) { index++; return one; }
			else if (index == 2) { index++; return two; }
			else if (index == 3) { index++; return three; }
			else return -1;
		}
	}
}
 