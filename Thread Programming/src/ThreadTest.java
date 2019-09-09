public class ThreadTest {
	public static void main(String[] args) {
		try {
			Counter c = new Counter();

			Thread t1 = new MyThread(c);
			Thread t2 = new Thread(new MyImple(c));
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
//			t1.interrupt();
//			t2.interrupt();

			System.out.println("Counter: " + c.value());
			System.out.println("DONE");
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	static class MyThread extends Thread {
		private Counter c;

		public MyThread(Counter c) {this.c = c;}
		public void run() {
			// 하고 싶은 일
//			for(int i = 0; i < 5; i++) {
//				System.out.println("MyThread...");
//				try {
//					Thread.sleep(2000); // 정적 메소드 
//				} catch (InterruptedException e) {
//					System.out.println("THREAD is interrupted");
//				}
//			}
			for (int i = 0; i < 500; i++) {
				c.increment();
				System.out.println(c.value() + "\t +");
			}
		}
	}

	static class MyImple implements Runnable { // 단일상속 때문에 Runnable interface가 존재
		private Counter c;
		
		public MyImple(Counter c) {this.c = c;}
		public void run() {
			// 하고 싶은 일
//			for(int i = 0; i < 10; i++) {
//				System.out.println("MyImple...");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					System.out.println("IMPLE is interrupted");
//				}
//			}
			for (int i = 0; i < 500; i++) {
				c.decrement();
				System.out.println(c.value() + "\t -");
			}
		}
	}
	static class Counter { // 객체에 대해 syncronized, 객체가 다르면 전혀 신경 안씀
		private int c = 0;
		public synchronized void increment() {
			if (c >= 10) {
				try {this.wait();}	
				catch (InterruptedException e) {}
			}
			c++;
			this.notify();
		}
		public synchronized void decrement() {
			if (c <= 0) {
				try {this.wait();}
		        catch (InterruptedException e) {}
			}
			c--;
			this.notify();
		}
		public synchronized int value() { return c;}
	}
}
