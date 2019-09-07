import java.util.Iterator;

public class OneTwoThreeMain {
	public static void main(String[] args) {
		OneTwoThree ott = new OneTwoThree(200, 100, 300);

		Iterator<Integer> iter = ott.iterator();
		while (iter.hasNext()) {System.out.print(iter.next() + " ");}
		
		System.out.println();
		for (Integer i : ott) {System.out.print(i + " ");}
	}
}
