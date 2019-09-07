package Chapter02;
// 2.8 모든 순열 나열하기   
import java.util.Scanner;

public class Permutation {
	static void swap(char[] list, int i, int j) {
		char tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}
	static String listToString(char[] list) {
		String s = "[ ";
		for(char ch :list) s += ch + " ";
		return s + " ]";
	}
	static void permute(char[] list, int i) {
		if(i == list.length-1) System.out.println(listToString(list));
		for(int k = i; k < list.length; k++) {
			swap(list, i, k);
			permute(list, i+1);
			swap(list, i, k);
		}
	}
	public static void main(String[] args) {
		char[] list = {'a', 'b', 'c', 'd'};
		System.out.println(listToString(list));
		permute(list, 0);
	}
}
