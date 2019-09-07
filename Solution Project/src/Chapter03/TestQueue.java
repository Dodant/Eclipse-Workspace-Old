package Chapter03;
// 3.2 큐의 개념 
import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		int[] data = {2,3,5,7,11};
		
		System.out.print("Queue input seq: ");
		for(int e : data) {
			que.add(e);
			System.out.print(e + " ");
		}
		System.out.println();
		
		System.out.println("Queue size: " + que.size());
		
		System.out.print("Queue output seq: ");
		while(!que.isEmpty()) {
			int e = que.remove();
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
