package binaryTree;

import algorithm.TreeNode;

public class BinaryTree_11 {

	// 寻找最大搜索子树
	public TreeNode findTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		return (TreeNode) help(root)[0];
	}

	// Object[] 所包括的内容:
	// TreeRoot; 最大搜索二叉子树的头节点
	// TreeNum; 最大搜索二叉子树的节点数
	// TreeMin; 最大搜索二叉子树的最小值
	// TreeMax; 最大搜索二叉子树的最大值
	public Object[] help(TreeNode root) {
		Object[] res = new Object[4];
		TreeNode TreeRootL = null;
		int TreeNumL = 0;
		int TreeMinL = -1;
		int TreeMaxL = -1;
		TreeNode TreeRootR = null;
		int TreeNumR = 0;
		int TreeMinR = -1;
		int TreeMaxR = -1;
	
		if (root.left != null) {
			Object[] temp = help(root.left);
			TreeRootL = (TreeNode) temp[0];
			TreeNumL = (int) temp[1];
			TreeMinL = (int) temp[2];
			TreeMaxL = (int) temp[3];
		}
		
		if (root.right != null) {
			Object[] temp = help(root.right);
			TreeRootR = (TreeNode) temp[0];
			TreeNumR = (int) temp[1];
			TreeMinR = (int) temp[2];
			TreeMaxR = (int) temp[3];
		}

		// 左右子树都为空的情况, 返回root
		if (root.left == null && root.right == null) {
			res[0] = root;
			res[1] = 1;
			res[2] = root.val;
			res[3] = root.val;
			// 只有左子树为空的情况
		} else if (root.left == null) {
			// 当root可以和右子树的最大搜索二叉子树连起来时, 返回root
			if (TreeRootR == root.right && root.val < TreeMinR) {
				res[0] = root;
				res[1] = 1 + TreeNumR;
				res[2] = root.val;
				res[3] = TreeMaxR;
				// 连不起来时,返回 TreeRootR
			} else {
				res[0] = TreeRootR;
				res[1] = TreeNumR;
				res[2] = TreeMinR;
				res[3] = TreeMaxR;
			}
			// 只有右子树为空的情况
		} else if (root.right == null) {
			// 当root可以和左子树的最大搜索二叉子树连起来时, 返回root
			if (TreeRootL == root.left && root.val > TreeMaxL) {
				res[0] = root;
				res[1] = 1 + TreeNumL;
				res[2] = TreeMinL;
				res[3] = root.val;
				// 连不起来时, 返回TreeRootL
			} else {
				res[0] = TreeRootL;
				res[1] = TreeNumL;
				res[2] = TreeMinL;
				res[3] = TreeMaxL;
			}
			// 左右子树均不为空
		} else {
			// 左右子树的最大搜索二叉子树的头节点都为root的孩子, 并且根节点值符合搜索二叉树的规范,就是说根节点和左右子树都能连起来
			if (TreeRootL == root.left && TreeRootR == root.right && TreeMaxL < root.val && root.val < TreeMinR) {
				res[0] = root;
				res[1] = TreeNumL + TreeNumR + 1;
				res[2] = TreeMinL;
				res[3] = TreeMaxR;
				// 否则, 返回左右子树中较大的那个
			} else {
				// L较大
				if (TreeNumL >= TreeNumR) {
					res[0] = TreeRootL;
					res[1] = TreeNumL;
					res[2] = TreeMinL;
					res[3] = TreeMaxL;
					// R较大
				} else {
					res[0] = TreeRootR;
					res[1] = TreeNumR;
					res[2] = TreeMinR;
					res[3] = TreeMaxR;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(6);
		TreeNode node1 = new TreeNode(1);
		TreeNode node0 = new TreeNode(0);
		TreeNode node3 = new TreeNode(3);
		TreeNode node12 = new TreeNode(12);
		TreeNode node10 = new TreeNode(10);
		TreeNode node13 = new TreeNode(13);
		TreeNode node4 = new TreeNode(4);
		TreeNode node14 = new TreeNode(14);
		TreeNode node20 = new TreeNode(20);
		TreeNode node16 = new TreeNode(16);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);
		TreeNode node11 = new TreeNode(11);
		TreeNode node15 = new TreeNode(15);
		node6.left = node1;
		node6.right = node12;
		node1.left = node0;
		node1.right = node3;
		node12.left = node10;
		node12.right = node13;
		node10.left = node4;
		node10.right = node14;
		node13.left = node20;
		node13.right = node16;
		node4.left = node2;
		node4.right = node5;
		node14.left = node11;
		node14.right = node15;
		System.out.println(new BinaryTree_11().findTree(node6));
	}
}
