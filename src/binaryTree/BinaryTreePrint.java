package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.TreeNode;



/**
 * 二叉树的宽度优先遍历, 需要打印出换行
 */
public class BinaryTreePrint {
	public void binaryTreePrint(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode last = root;
		TreeNode nlast = null;
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.remove();
			System.out.print(node.val+" ");
			if(node.left!=null){
				queue.add(node.left);
				nlast = node.left;
			}
			if(node.right!=null){
				queue.add(node.right);
				nlast = node.right;
			}
			if(last==node){
				System.out.println();
				last = nlast;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		new BinaryTreePrint().binaryTreePrint(root);
	}
}
