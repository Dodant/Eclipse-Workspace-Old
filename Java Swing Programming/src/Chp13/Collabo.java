package Chp13;

public class Collabo {
	private int bread = 0;
	private int pack = 0;

	synchronized public void bake() {
		if (this.bread == 5) {
			notify();
			try {wait();} 
			catch (InterruptedException e) {return;}
		}
		this.bread++;
		System.out.println("Bread = " + bread);
	}
	synchronized public void pack() {
		if (this.bread != 5) {
			try {wait();} 
			catch (InterruptedException e) {System.err.println("pack interrupted");}
		}
		this.bread = 0;
		this.pack++;
		System.out.println("Pack = " + pack);
		notify();
	}
	public static void main(String[] args) {
		Collabo store = new Collabo();
		BakerThread b = new BakerThread(store);
		PackerThread p = new PackerThread(store);
		b.start();
		p.start();
	}
}
class BakerThread extends Thread {
	Collabo store;
	BakerThread(Collabo store) {this.store = store;}
	@Override
	public void run() {
		while (true) {
			store.bake();
			try {sleep(1000);} 
			catch (InterruptedException e) {
				System.err.println("Baker interrupted");
				return;
			}
		}
	}
}
class PackerThread extends Thread {
	Collabo store;
	PackerThread(Collabo store) {this.store = store;}
	@Override
	public void run() {
		while (true) {
			store.pack();
			try {sleep(1000);} 
			catch (InterruptedException e) {
				System.err.println("Packer interrupted");
				return;
			}
		}
	}
}