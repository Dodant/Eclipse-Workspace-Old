package Chapter04;
// 4.2.4 이진트리의 순회 
public class BinaryTreeTraversalTest {

	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode("A");
		BinaryTreeNode b = new BinaryTreeNode("B");
		BinaryTreeNode c = new BinaryTreeNode("C");
		BinaryTreeNode d = new BinaryTreeNode("D");
		BinaryTreeNode t1 = new BinaryTreeNode("+", b, c);
		BinaryTreeNode t2 = new BinaryTreeNode("*", t1, d);
		BinaryTreeNode root = new BinaryTreeNode("+", a, t2);
		
		BinaryTreeTraversal traversal = new BinaryTreeTraversal();
		
		System.out.println("The elements in inorder are: ");
		traversal.inOrder(root);
		System.out.println();
		
		System.out.println("The elements in preorder are: ");
		traversal.preOrder(root);
		System.out.println();
		
		System.out.println("The elements in postorder are: ");
		traversal.postOrder(root);
		System.out.println();
		
		System.out.println("The elements in level order are: ");
		traversal.levelOrder(root);
		System.out.println();
	

	}

}
