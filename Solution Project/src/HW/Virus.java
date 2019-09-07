//package HW;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayDeque;
//import java.util.Deque;
//import java.util.Scanner;
//import Chapter04.BinaryTreeNode;
//import Chapter04.BinaryTreeTraversal;
//
//public class Virus {
//	
//	public static int N(BinaryTreeNode tree) {
//		if (tree.countChild() == 0) return 1;
//		if (tree.countChild() == 1) return 1;
//		return Math.min(N(tree.leftChild), N(tree.rightChild)) + 1;
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc;
//		try {
//			sc = new Scanner(new File("virus08.in"));
//			sc.nextInt();
//			Deque<BinaryTreeNode> queueTree = new ArrayDeque<BinaryTreeNode>();
//			Deque<Integer> queueInt = new ArrayDeque<Integer>();
//			BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//			queueTree.addLast(root);
//			
//			while(sc.hasNext()) {
//				int left = sc.nextInt();
//				int right = sc.nextInt();
//				
//				queueInt.addLast(left);
//				queueInt.addLast(right);
//				
//				BinaryTreeNode<Integer> subroot = queueTree.removeFirst();
//
//				int lint = queueInt.removeFirst();
//				int rint = queueInt.removeFirst();
//
//				if(lint != 0) {
//					BinaryTreeNode<Integer> leftree = new BinaryTreeNode<>(lint);
//					subroot.setLeftChild(leftree);
//					queueTree.addLast(leftree);
//				}
//				if(rint != 0) {
//					BinaryTreeNode<Integer> rightree = new BinaryTreeNode<>(rint);
//					subroot.setRightChild(rightree);					
//					queueTree.addLast(rightree);
//				}
//			}
//			System.out.println(N(root));
////			new BinaryTreeTraversal().preOrder(root);
//
////			long startTime = System.currentTimeMillis();
////			long endTime = System.currentTimeMillis();
////			System.out.println((endTime - startTime) + "ms");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//}

package HW;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Virus {
	
	static int[] leftArr;
	static int[] rightArr;
	
	public static int N(int n) {
		if (leftArr[n] == 0 && rightArr[n] == 0) return 1;
		if ((leftArr[n] == 0 && rightArr[n] != 0)||
				(leftArr[n] != 0 && rightArr[n] == 0)) return 1;
		return Math.min(N(leftArr[n]), N(rightArr[n])) + 1;
	}
	
	public static void virusInput(String file) {
		try {
			long startTime = System.currentTimeMillis();
			Scanner sc = new Scanner(new File(file));
			int rows = sc.nextInt();			
			leftArr = new int [rows];
			rightArr = new int [rows];
			
			for (int i = 0; i < rows; i++) {
				int lint = sc.nextInt();
				int rint = sc.nextInt();
				if (lint != 0) leftArr[i] = lint - 1;
				else leftArr[i] = lint;
				if (rint != 0) rightArr[i] = rint - 1;
				else rightArr[i] = rint;
				
			}
			System.out.print(N(0) + "\t");
			long endTime = System.currentTimeMillis();
			System.out.println((endTime - startTime) + "ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		virusInput("virus01.in");
		virusInput("virus02.in");
		virusInput("virus03.in");
		virusInput("virus04.in");
		virusInput("virus05.in");
		virusInput("virus06.in");
		virusInput("virus07.in");
		virusInput("virus08.in");
	}
}

//package HW;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class Virus {
//	static double baseLogAndAdjust(double x, double base) {
//		return Math.log10(x) / Math.log10(base);
//	}
//	public static void virusInput(String file) {
//		try {
//			long startTime = System.currentTimeMillis();
//			Scanner sc = new Scanner(new File(file));
//			sc.nextInt();
//			int lint, rint, count = 1;
//
//			while(sc.hasNext()) {
//				lint = sc.nextInt(); rint = sc.nextInt();
//				if (lint == 0 || rint == 0) break;
//				count++;
//			}
//			System.out.print((int)baseLogAndAdjust(count, 2) + 1 + "\t");
//			long endTime = System.currentTimeMillis();
//			System.out.println((endTime - startTime) + "ms");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void main(String[] args) {
//		virusInput("virus01.in");
//		virusInput("virus02.in");
//		virusInput("virus03.in");
//		virusInput("virus04.in");
//		virusInput("virus05.in");
//		virusInput("virus06.in");
//		virusInput("virus07.in");
//		virusInput("virus08.in");
//	}
//}