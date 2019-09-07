package version3;

public class Orange extends Fruit implements Comparable<Orange> {
	public Orange(int size) {
		super("Orange", size);
	}

	@Override
	public int compareTo(Orange a) {
		return super.compareTo(a);
	}
}