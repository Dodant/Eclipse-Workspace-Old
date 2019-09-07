package version3;

import java.util.Comparator;

public class MixedComparator implements Comparator<Fruit> {
	@Override
	public int compare(Fruit f1, Fruit f2) {
		return f1.size < f2.size ? -1 : f1.size == f2.size ? 0 : 1;
	}
}
