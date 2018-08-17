package binaryTree;

import algorithm.TreeNode;

public class BinaryTree_7 {

	// 寻找node节点的后继节点, node不一定是root, 如果没有就返回空
	public ParentTreeNode getNext(ParentTreeNode node){
		if(node.right!=null){
			ParentTreeNode temp = node.right;
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}

		ParentTreeNode s = node;
		ParentTreeNode p = node.parent;
		while(p!=null&&p.left!=s){
			s = s.parent;
			p = p.parent;
		}
		return p;
	}
	
	public static void main(String[] args) {
		ParentTreeNode node6 = new ParentTreeNode(6);
		ParentTreeNode node3 = new ParentTreeNode(3);
		ParentTreeNode node9 = new ParentTreeNode(9);
		ParentTreeNode node1 = new ParentTreeNode(1);
		ParentTreeNode node4 = new ParentTreeNode(4);
		ParentTreeNode node8 = new ParentTreeNode(8);
		ParentTreeNode node10 = new ParentTreeNode(10);
		ParentTreeNode node7 = new ParentTreeNode(7);
		node6.left = node3;
		node6.right = node9;
		node3.parent = node6;
		node3.left = node1;
		node3.right = node4;
		node9.parent = node6;
		node9.left = node8;
		node9.right = node10;
		node1.parent = node3;
		node4.parent = node3;
		node8.parent = node9;
		node8.left = node7;
		node7.parent = node8;
		node10.parent = node9;
		System.out.println(new BinaryTree_7().getNext(node6));
	}
	
}
