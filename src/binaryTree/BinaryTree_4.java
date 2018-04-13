package binaryTree;

import algorithm.TreeNode;

public class BinaryTree_4 {

	//是否为平衡二叉树
	public boolean isBalance(TreeNode root){
		boolean[] res = new boolean[1]; // 写成数组的形式, 相当于传递指针, 便于在递归函数中使用
		res[0] = true;
		getHeight(root, 0, res); //初始时应该为0而不是1, 虽说等于多少并不影响最后的结果, 但是等于0时高度的计算才是正确的
		return res[0];
	}
	
	public int getHeight(TreeNode root, int level, boolean[] res){
		if(root==null){
			return level;
		}
		int lH = getHeight(root.left, level+1, res);
		if(!res[0]){
			return level;
		}
		int rH = getHeight(root.right, level+1, res);
		if(!res[0])
			return level;
		if(Math.abs(lH-rH)>1){
			res[0] = false;
		}
		return Math.max(lH, rH);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(5);
		System.out.println(new BinaryTree_4().isBalance(root));
	}
}
