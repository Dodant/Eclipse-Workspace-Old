package Chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
	private static class Node<E>{
		private E item;
		private Node<E> left;
		private Node<E> right;
		
		private Node(E item) {
			this.item = item;
			this.left = null;
			this.right = null;			
		}
		
		private Node(E item, Node<E> left, Node<E> right) {
			this.item = item;
			this.left = left;
			this.right = right;						
		}
	}
	
	private Node<E> root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(E value) {
		root = new Node<>(value);
	}
	
	public E find(E item) {
		Node<E> node = root;
		while(node != null) {
			if(item.compareTo(node.item) < 0) node = node.left;
			else if (item.compareTo(node.item) > 0) node = node.right;
			else return node.item;
		}
		return null;
	}
	
	public void add(E value) {
		root = add(value, root);
	}
	
	private Node<E> add(E value, Node<E> node){
		if(node == null) return new Node<>(value);
		if(value.compareTo(node.item) == 0) {
			node.item = value;
			return node;
		}
		if(value.compareTo(node.item) < 0) { node.left = add(value, node.left); }
		else { node.right = add(value, node.right); }
		return node;
	}
	
	public void remove(E key) {
		root = remove(key, root);
	}
	
	private Node<E> remove(E value, Node<E> node){
		if (node == null) return null;
		if (value.compareTo(node.item) < 0) { node.left = remove(value, node.left); }
		else if (value.compareTo(node.item) < 0) { node.right = remove(value, node.right); }
		else { 
			if(node.left == null) return node.right;
			else if(node.right == null) return node.left;
			else {
				node.item = getRightmost(node.left);
				node.left = remove(node.item, node.left);
			}
		}
		return node;
	}
	
	private E getRightmost(Node<E> node) {
		assert(node != null);
		Node<E> right = node.right;
		if(right == null) return node.item;
		else {return getRightmost(right);}
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	public String toString() {
		return toString(root);
	}
	
	private String toString(Node<E> node) {
		if(node == null) return "()";
		return "(" + node.item + ", " + toString(node.left) + ", " + toString(node.right) + ")";
	}
	
	public E[] toArray() {
		List<E> list = new ArrayList<>();
		inOrder(root, list);
		return (E[]) list.toArray((E[]) new Comparable[] {});
	}
	
	private void inOrder(Node<E> node, List<E> list) {
		if(node == null) return;
		inOrder(node.left, list);
		list.add(node.item);
		inOrder(node.right, list);
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(5);
		tree.add(8);
		tree.add(9);
		tree.add(3);
		tree.add(1);
		tree.add(6);
		tree.add(7);
		tree.add(4);
		
		System.out.println(tree);
		System.out.println(Arrays.toString(tree.toArray()));
		
//		if(tree.find(3) != 3) System.out.println("error: tree has 3, should not occur!");
//		if(tree.find(4) != null) System.out.println("error: tree doesn't have 4, should not occur!");
		
		tree.remove(5);

		System.out.println(tree);
		System.out.println(Arrays.toString(tree.toArray()));
	}

}
