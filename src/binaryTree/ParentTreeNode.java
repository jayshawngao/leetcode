package binaryTree;

public class ParentTreeNode {

	public int val;
	public ParentTreeNode left;
	public ParentTreeNode right;
	public ParentTreeNode parent;
	public ParentTreeNode(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
