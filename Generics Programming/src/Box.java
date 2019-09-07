import java.util.ArrayList;

public class Box<E> { 	// E는 타입인자 / 모든 E에 대해서 
						// 어떤 E에 대해서 - 와일드카드 
	E elem;
	public Box(E elem) {this.elem = elem;}
	public void put(E elem) {this.elem = elem;}
	public E get() {return elem;}
	
	public static <T> boolean isEmpty(Box<T> box) {	// 모든 E에 대해서 & 모든 T에 대해서 
		T elem = box.get();
		if(elem == null) return true;
		else return false;
	}
	public static void main(String[] args) {
		Pair<Integer, String> pls = new MyPair();
		pls.fst();
		pls.snd();
	}
}

class MyPair implements Pair<Integer, String>{
	public Integer fst() {return null;}
	public String snd() {return null;}
}
