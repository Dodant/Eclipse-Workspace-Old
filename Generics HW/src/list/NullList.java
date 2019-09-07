package list;

public class NullList<T> extends List<T> {
	public NullList() { }
	public boolean isNull() {return true;}
	public boolean isPair() {return false;}
	public String toString() {return "()";}
}
