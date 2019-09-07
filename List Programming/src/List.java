
abstract class List {
	public abstract boolean isNull();
	public abstract boolean isPair();
	public void print() {
		System.out.println(this.toStriing());
	}
	public String toStriing() {
		List list = this;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		while (list instanceof Pair) {
			Pair pair = (Pair) list;
			sb.append(pair.first());
			if (!(pair.second() instanceof NullList)) sb.append(", ");
			list = pair.second();
		}
		sb.append("]");
		return sb.toString();
	}
	public int length() {
		int leng = 0;
		List list = this;
		while (list instanceof Pair) {
			Pair pair = (Pair) list;
			leng++;
			list = pair.second();
		}
		return leng;
	}
	public int sum() {
		int sum = 0;
		List list = this;
		while (list instanceof Pair) {
			Pair pair = (Pair) list;
			sum += pair.first();
			list = pair.second();
		}
		return sum;
	}
	public List concat(List list2) { 	// 재귀함수 - 뒤에서부터 끌어온다, for문으로 뒤에서 끌어오는 건 힘들다.
		List list1 = this; 
		if (list1 instanceof NullList) return list2;
		else {
			Pair pair = (Pair) list1;
			return new Pair(pair.first(), pair.second().concat(list2));
		}
	}
	public List reverse() {
		List list1 = this;
		if (list1 instanceof NullList) return this;
		else {
			Pair pair = (Pair) list1;
			return pair.second().reverse().concat(new Pair(pair.first(), new NullList()));
		}
	}

//	public List take(int idx) {
//		List list = new Pair(((Pair)this).first(), new NullList());
//		Pair pair1 = (Pair)this;
//		if(idx > this.length()) return this;
//		for(int i = 0; i < idx - 1 ; i++) {
//			list = list.concat(new Pair(((Pair)pair1.second()).first(), new NullList()));
//			pair1 = (Pair)pair1.second();
//		}
//		return list;
//	}
	public List take(int j) {
		List list = this;
		list = list.reverse();
		if (j > this.length())
			return this;
		for (int i = 0; i < this.length() - j; i++) {
			Pair pair = (Pair) list;
			list = pair.second();
		}
		return list.reverse();
	}
	public List drop(int idx) {
		Pair pair = (Pair) this;
		if (idx > this.length())
			return new NullList();
		for (int i = 0; i < idx; i++) {
			pair = (Pair) pair.second();
		}
		return pair;
	}
	//재귀함수로 구현 
	public List recTake(int num) {
		List list = this;
   	 	Pair pair = (Pair) list;
        if (num > 0 && list instanceof Pair)
             return new Pair(pair.first(), pair.second().recTake(num - 1));
        else
             return new NullList();
	 }
	public List recDrop(int num) {
		List list = this;
   	 	Pair pair = (Pair) list;
		if (num > 0 && list instanceof Pair) 
			return pair.second().recDrop(num - 1);
		else 
			return this;
	}
}

class NullList extends List {
	public NullList() {}
	public boolean isNull() {return true;}
	public boolean isPair() {return false;}
	public String toString() {return "()";}
}

class Pair extends List {
	private int first;
	private List second;

	public Pair(int first, List second) {
		this.first = first;
		this.second = second;
	}
	public boolean isNull() {return false;}
	public boolean isPair() {return true;}
	public int first() {return this.first;}
	public List second() {return this.second;}
	public String toString() {return "(" + first + ", " + second.toString() + ")";}
}