
public abstract class Tree {
	abstract boolean isNullTree();
	abstract boolean isBinTree();
	public abstract void print();
	public int count() {
		if (this.isNullTree()) {
			return 0;
		} else {
			BinTree bt = (BinTree)this;
			return bt.getLeft().count() + bt.getRight().count() + 1;
		}
	};
	public List preorder() {
		if(this.isNullTree()) {
			return new NullList();
		} else {
			BinTree bt = (BinTree)this;
			return new Pair(bt.getValue(), new NullList())
					.concat(bt.getLeft().preorder())
					.concat(bt.getRight().preorder());
		}
	};
	public List postorder() {
		if(this.isNullTree()) {
			return new NullList();
		} else {
			BinTree bt = (BinTree)this;
			return bt.getLeft().postorder()
					.concat(bt.getRight().postorder())
					.concat(new Pair(bt.getValue(), new NullList()));
		}
	};
	public List inorder() {
		if(this.isNullTree()) {
			return new NullList();
		} else {
			BinTree bt = (BinTree)this;
			return bt.getLeft().inorder()
					.concat(new Pair(bt.getValue(), new NullList()))
					.concat(bt.getRight().inorder());
		}
	};
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if(this.isNullTree()) {
			sb.append("()");
			return sb.toString();
		} else {
			BinTree bt = (BinTree)this;
			sb.append("(");
			sb.append(bt.getLeft().toString());
			sb.append(":");
			sb.append(bt.getValue());
			sb.append(":");
			sb.append(bt.getRight().toString());
			sb.append(")");
		}
		return sb.toString();
	}
}

class NullTree extends Tree {
	public boolean isNullTree() {return true;}
	public boolean isBinTree() {return false;}
	public void print() {}
	public int count() {return 0;}
}

class BinTree extends Tree {
	private Tree left;
	private Tree right;
	private int value;
	public BinTree(Tree left, int value, Tree right) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	public boolean isNullTree() {return false;}
	public boolean isBinTree() {return true;}
	public void print() {}
	public int count() {return 0;}
	public Tree getLeft() {return left;}
	public void setLeft(Tree left) {this.left = left;}
	public Tree getRight() {return right;}
	public void setRight(Tree right) {this.right = right;}
	public int getValue() {return value;}
	public void setValue(int value) {this.value = value;}
}