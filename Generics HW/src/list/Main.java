package list;

public class Main {

	public static void main(String[] args) {
		// [1,2,3,4,5]
		List<Integer> list1 = 
				new Pair<Integer>(1, 
						new Pair<Integer>(2,
								new Pair<Integer>(3, 
										new Pair<Integer>(4, 
												new Pair<Integer>(5, 
														new NullList<Integer>())))));
		// []
		//List<Integer> list2 = new NullList<Integer>();

		// ["Playing", "With", "Java"]
		List<String> list2 = 
				new Pair<String>("Playting",
						new Pair<String>("With", 
								new Pair<String>("Java", 
										new NullList<String>())));
		// list3 = [10,11]
		List<Integer> list3 = 
				new Pair<Integer>(10, 
						new Pair<Integer>(11, 
								new NullList<Integer>()));

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);

		System.out.println(list1.reverse().reverse());
		System.out.println(list1.concat(list3.reverse()));

		System.out.println(take(2, list1));
		System.out.println(drop(2, list2));
	}

	public static <T> List<T> take(int n, List<T> l) {
		if (n > 0 && l.isPair()) {
			Pair<T> pair = (Pair<T>) l;
			return new Pair<T>(pair.first(), take(n - 1, pair.second()));
		} else
			return new NullList<T>();
	}

	public static <T> List<T> drop(int n, List<T> l) {
		if (n > 0 && l.isPair()) {
			Pair<T> pair = (Pair<T>) l;
			return drop(n - 1, pair.second());
		} else
			return l;
	}
}
