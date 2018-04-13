package binaryTree;

import java.util.Arrays;
import java.util.Stack;

import algorithm.TreeNode;

public class BinaryTree_9 {

	// 寻找搜索二叉树中两个位置错误的节点
	public int[] findMistake(TreeNode root){
		int[] res = new int[2];
		Arrays.fill(res, -1);
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null; //当前节点的上一个节点
		while(!stack.isEmpty()||root!=null){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(pre!=null&&pre.val>root.val){
				if(res[0]==-1)
					res[0]=pre.val;
				res[1]=root.val;
			}
				
			pre = root;
			root = root.right;
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		int[] res = new BinaryTree_9().findMistake(root);
		System.out.println(Arrays.toString(res));
	}
}
