package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.TreeNode;

public class BinaryTree_6 {

	// 判断是否是完全二叉树
	public boolean isComplete(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		boolean flag = false; // 当flag==true, 表示之前已经出现过某个节点的左右孩子不满, 之后遍历的所有节点只能是叶子节点
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (flag) {
				// flag为true , 并且当前node不是叶子节点, 则返回false
				if (node.left != null || node.right != null) {
					return false;
				}
			} else {
				if (node.left != null) {
					queue.offer(node.left);
					if (node.right != null) {
						queue.offer(node.right);
					} else {
						// 如果左孩子不为空, 右孩子为空,flag置为true
						flag = true;
					}
					// 如果node.left为空的情况下, node.right不为空, 违反完全二叉树的原则, 返回false;
				} else if (node.right != null) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		System.out.println(new BinaryTree_6().isComplete(root));
	}
}
