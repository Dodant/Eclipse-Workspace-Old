package Chapter04;
// 4.2 이진트리 
public class BinaryTreeNode<T> {
	public T element;
	public BinaryTreeNode<T> leftChild;
	public BinaryTreeNode<T> rightChild;
	
	public BinaryTreeNode() {}
	public BinaryTreeNode(T theElement) {
		element = theElement;
		leftChild = null;
		rightChild = null;
	}
	public BinaryTreeNode(T theElement, BinaryTreeNode left, BinaryTreeNode right) {
		element = theElement;
		leftChild = left;
		rightChild = right;
	}
	
	public void setLeftChild(BinaryTreeNode left) {
		leftChild = left;
	}
	public void setRightChild(BinaryTreeNode right) {
		rightChild = right;
	}
	public void setElement(T theElement) {
		element = theElement;
	}
	public String toString() {
		return element.toString();
	}
	public int countChild() {
		if (this.leftChild != null && this.rightChild != null) return 2;
		if (this.leftChild != null || this.rightChild != null) return 1;
		return 0;
	}
}
