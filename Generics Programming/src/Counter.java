import java.util.Iterator;

public class Counter implements Iterable<Integer> {
	private int max_count;
	public Counter(int max_count) {this.max_count = max_count;}	
	public Iterator<Integer> iterator() {return new MyIterator();}
	
	class MyIterator implements Iterator<Integer> {
		private int i;
		public MyIterator() {i = 1;}
		public boolean hasNext() {return i <= max_count;}
		public Integer next() {return i++;}
	}
}

