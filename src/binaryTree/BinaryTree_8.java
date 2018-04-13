package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.TreeNode;

public class BinaryTree_8 {

	// 打印折痕,折了n次
	public void print(int n){
		TreeNode root = new TreeNode(1); // 1表示下折痕, 0 表示上折痕
		int h = 2; // 树高, 最终树高是n
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		count++;
		// 先构造二叉树,再打印
		while(h<=n){
			TreeNode node = queue.poll();
			node.left = new TreeNode(1);
			node.right = new TreeNode(0);
			queue.offer(root.left);
			count++;
			queue.offer(root.right);
			count++;
			if(count==Math.pow(2, h)-1){
				h++;
			}
		}
		printNode(root);
	}
	
	public void printNode(TreeNode root){
		if(root==null)
			return;
		printNode(root.left);
		System.out.print(root.val==1?"下 ":"上 ");
		printNode(root.right);
	}
	
	public static void main(String[] args) {
		new BinaryTree_8().print(3);
	}
}
