package Chapter03;
// 3.2 큐의 개념 
public class CircularQueue<E> {
	
	private E data[];
	private int front;
	private int count;
	
	public CircularQueue() {
		data = (E[])new Object[1];
		front = 0;
		count = 0;
	}
	
	public void addLast(E value) {
		if(count == data.length) {
			ensureCapacity(2 % data.length);
		}
		int rear = (front + count) % data.length;
		data[rear] = value;
		count++;
	}
	
	public E getFirst() throws Exception {
		if(count == 0) {
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		}
		return data[front];
	}
	
	public E getLast() throws Exception {
		if(count == 0) {
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		}
		int rear = (front + count - 1) % data.length;
		return data[rear];
	}
	
	public synchronized Object removeFrist() throws Exception {
		if(count == 0) {
			throw new ArrayIndexOutOfBoundsException("Queue is empty");
		}
		Object value = data[front];
		front = (front + 1) % data.length;
		count--;
		return value;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	private void ensureCapacity(int newCapacity) {
		if(newCapacity <= data.length) {
			return;
		}
		E[] newArray = (E[])new Object[newCapacity];
		for(int i = 0; i < count; i++) {
			newArray[i] = data[front];
			front = (front + 1) % data.length;
		}
		data = newArray;
		front = 0;
	}
}
