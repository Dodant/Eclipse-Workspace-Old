package Chapter03;
// 3.4 스택의 응용 
// 3.5 큐를 이용한 열차 순열 구하기 
import java.util.ArrayDeque;
import java.util.Deque;

public class RailroadwithQueues {
	static class UnableOpException extends Exception {
		UnableOpException(String msg) {
			super(msg);
		}
	}

	static void railroad(int[] cars, int nTracks) {
		int n = cars.length;
		Deque<Integer>[] tracks = new Deque[nTracks];
		for (int i = 0; i < tracks.length; i++) {
			tracks[i] = new ArrayDeque<>();
		}

		int expected = 1;
		try {
			for (int i = 0; i < n; i++) {
				int current = cars[i];
				if (current == expected) {
					System.out.printf("Move car#%d in inway to outway\n", current);
					expected++;
					while (smallestInTrack(tracks) == expected) {
						retrieveCar(tracks, expected);
						expected++;
					}
				} else {
					putInCar(tracks, current);
				}
			}
		} catch (UnableOpException e) {
			System.out.println(e);
		}
	}
	// 대기선로에 차량을 추가 
	static void putInCar(Deque<Integer>[] tracks, int car) throws UnableOpException {
		int target = -1;
		for (int i = 0; i < tracks.length; i++) {
			if (tracks[i].isEmpty()) {
				if (target == -1) {
					target = i;
				}
				continue;
			}
			if (tracks[i].peek() > car) {
				if (target == -1 || tracks[i].peek() < tracks[target].peek()) {
					target = i;
				}
			}
		}
		if (target == -1) {
			throw new UnableOpException("Unable to Puch car#" + car + " into any tracks");
		}
		tracks[target].push(car);
		System.out.printf("Move car#%d in inway to H%d\n", car, target + 1);
	}
	// 대기선로에서 해당 차량을 꺼내옴 
	static void retrieveCar(Deque<Integer>[] tracks, int car) throws UnableOpException {
		for (int i = 0; i < tracks.length; i++) {
			if (tracks[i].isEmpty()) {
				continue;
			}
			if (tracks[i].peek() == car) {
				tracks[i].pop();
				System.out.printf("Move car#%d in H%d to outway\n", car, i + 1);
				return;
			}
		}
		throw new UnableOpException("Unable to Pop car#" + car + " from any tracks");
	}
	// 대기선로에서 가장 작은 번호의 차량을 검색 
	static int smallestInTrack(Deque<Integer>[] tracks) {
		int smallest = Integer.MAX_VALUE;

		for (int i = 0; i < tracks.length; i++) {
			if (!tracks[i].isEmpty() && tracks[i].peek() < smallest) {
				smallest = tracks[i].peek();
			}
		}
		return smallest;
	}

	public static void main(String[] args) {
		int[] cars = { 3, 4, 2, 6, 5, 1 };

		System.out.print("Input Sequence: ");
		for (int i = 0; i < cars.length; i++) {
			System.out.print(" " + cars[i]);
		}
		System.out.println();

		railroad(cars, 3);
	}

}
