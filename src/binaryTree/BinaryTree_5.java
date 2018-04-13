package binaryTree;

import java.util.Stack;

import algorithm.TreeNode;

public class BinaryTree_5 {

	// 判断是否是搜索二叉树
	public boolean isSearchBinaryTree(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		while(!stack.isEmpty()||root!=null){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(pre!=null&&pre.val>root.val){
				return false;
			}
			pre = root;
			System.out.print(root+" ");
			root =root.right;
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(6);
		BinaryTree_5 binaryTree_5 = new BinaryTree_5();
		System.out.println(binaryTree_5.isSearchBinaryTree(root));
	}
	
}
