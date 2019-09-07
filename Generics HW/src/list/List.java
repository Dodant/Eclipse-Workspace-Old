package list;

public abstract class List <T> {
	public abstract boolean isNull();
	public abstract boolean isPair();

	public int length() {
		int len = 0;
		List<T> list = this;
		while (list instanceof Pair) {
			Pair<T> pair = (Pair<T>) list;
			len++;
			list = pair.second();
		}
		return len;
	}

	public List<T> concat(List<T> l2) {
		List<T> l1 = this.reverse();
		List<T> concat = l2;
		while (l1 instanceof Pair) {
			Pair<T> p1 = (Pair<T>) l1;
			concat = new Pair<T>(p1.first(), concat);
			l1 = p1.second();
		}
		return concat;
	}

	public List<T> reverse() {
		List<T> list = this;
		List<T> reverse = new NullList<T>();
		while (list instanceof Pair) {
			Pair<T> pair = (Pair<T>) list;
			reverse = new Pair<T>(pair.first(), reverse);
			list = pair.second();
		}
		return reverse;
	}
}