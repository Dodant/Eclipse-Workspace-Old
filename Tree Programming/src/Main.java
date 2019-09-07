
public class Main {
	public static void main(String[] args) {
		Tree nulltree = new NullTree();
		Tree tree1 = new BinTree(nulltree, 1, nulltree); 
		Tree tree2 = new BinTree(nulltree, 2, nulltree); 
		Tree tree4 = new BinTree(tree1, 4, tree2);
		Tree tree3 = new BinTree(nulltree, 3, nulltree); 
		Tree tree5 = new BinTree(tree4, 5, tree3); 
		
		System.out.println(tree5.toString());
		System.out.println(tree5.preorder().toStriing());
		System.out.println(tree5.postorder().toStriing());
		System.out.println(tree5.inorder().toStriing());
		System.out.println(tree5.count());
	}
}
