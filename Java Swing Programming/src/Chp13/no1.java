package Chp13;
import java.lang.Thread;
import java.util.Scanner;

public class no1 extends Thread {
	public static void main(String[] args) {
		System.out.print("아무 키나 입력 >> ");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		no1 th = new no1();
		th.start();
		System.out.println("스레드 실행 시작");
	}
	public void run() {
		System.out.println("스레드 실행 시작");
		for(int n = 1; n <= 10; n++) System.out.print(n + " ");
		System.out.printf("\n스레드 종료");
	}
}
