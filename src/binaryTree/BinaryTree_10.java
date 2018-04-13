package binaryTree;

import algorithm.TreeNode;

public class BinaryTree_10 {

	// int[]包含两个值 
	// 1.以root为头的树上的最大距离, 计算公式 Max(LMax1, RMax1, LMax2+RMax2+1)
	// 2.以root为头的树上和root之间的最大距离, 计算公式 Max(LMax2+1, RMax2+1)
	public int[] help(TreeNode root){
		int[] res = new int[2];
		int LMax1=0, //以root.left为头的树上的最大距离 
		LMax2=0, // 以root.left为头的树上和root.left之间的最大距离
		RMax1=0, // 以root.right为头的树上的最大距离
		RMax2=0; // 以root.right为头的树上和root.right之间的最大距离
		
		if(root.left!=null){
			int[] temp = help(root.left);
			LMax1 = temp[0];
			LMax2 = temp[1];
		}
		
		if(root.right!=null){
			int[] temp = help(root.right);
			RMax1 = temp[0];
			RMax2  =temp[1];
		}
		
		res[0] = Math.max(Math.max(LMax1, RMax1),LMax2+RMax2+1);
		res[1] = Math.max(LMax2+1, RMax2+1);
		return res;
	}
	
	public int maxDistance(TreeNode root){
		return help(root)[0];
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(new BinaryTree_10().maxDistance(root));
	}
}
