package Chapter04;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinaryTreeTraversal {
	public void visit(BinaryTreeNode t) {
		System.out.print(t.element + " ");
	}
	public void preOrder(BinaryTreeNode t) {
		if (t == null) {
			return;
		}
		visit(t);
		preOrder(t.leftChild);
		preOrder(t.rightChild);
	}
	public void inOrder(BinaryTreeNode t) {
		if (t == null) {
			return;
		}
		inOrder(t.leftChild);
		visit(t);
		inOrder(t.rightChild);
	}
	public void postOrder(BinaryTreeNode t) {
		if (t == null) {
			return;
		}
		postOrder(t.leftChild);
		postOrder(t.rightChild);
		visit(t);
	}
	public void levelOrder(BinaryTreeNode t) {
		Deque<BinaryTreeNode> q = new ArrayDeque<>();
		q.addLast(t);
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.removeFirst();
			visit(node);
			if(node.leftChild != null) {
				q.addLast(node.leftChild);
			}
			if(node.rightChild != null) {
				q.addLast(node.rightChild);
			}
		}
	}

}
