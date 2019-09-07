package list;

public class Pair<T> extends List<T> {
	private T first;
	private List<T> second; 

	public Pair(T first, List <T> second) {
		super();
		this.first = first;
		this.second = second;
	}
	public String toString() {
		return "(" + first + ", " + second.toString() + ")";
	}
	public boolean isNull() {return false;}
	public boolean isPair() {return true;}
	public T first() {return first;}
	public List<T> second() {return second;}
}
