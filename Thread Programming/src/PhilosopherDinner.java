public class PhilosopherDinner {
    public static void main(String[] args) throws InterruptedException {
        try {
        	String lock1 = "lock1";
	        String lock2 = "lock2";
	        String lock3 = "lock3";
	        String lock4 = "lock4";
	        String lock5 = "lock5";
	
	        Thread p1 = new ThreadPhilosopher("A", lock1, lock2, 30);
	        Thread p2 = new ThreadPhilosopher("B", lock2, lock3, 30);
	        Thread p3 = new ThreadPhilosopher("C", lock3, lock4, 30);
	        Thread p4 = new ThreadPhilosopher("D", lock4, lock5, 30);
	        Thread p5 = new ThreadPhilosopher("E", lock1, lock5, 30); // 사이클을 끊는다.
	
	        p1.start(); p2.start(); p3.start(); p4.start(); p5.start();
	        p1.join();  p2.join();  p3.join();  p4.join();  p5.join();
	
	        System.out.println("Finished...");
        } catch (InterruptedException e) {}
    }
}

class ThreadPhilosopher extends Thread {
    String name;
    String left, right;
    int count;

    ThreadPhilosopher(String name, String left, String right, int counter) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.count = counter;
    }
    public void run () {
        while (count > 0) {
            synchronized (left) {
                System.out.println(name + " got " + left);
                synchronized (right) { // 식사를 한다.
                     System.out.println(name + " got " + right);
                     count--;
					}
                }
            System.out.println(name + " released both. / Left Count: " + count);
        }
    }
}