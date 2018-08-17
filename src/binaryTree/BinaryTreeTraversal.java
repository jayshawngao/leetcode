package binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import algorithm.TreeNode;

/**
 * 二叉树遍历 先中后序的递归非递归版本
 * 
 * @ClassName: BinaryTreeTraversal
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Jayshawn
 * @date 2018年1月6日 上午10:46:21
 *
 */
public class BinaryTreeTraversal {

	public void preOrderRec(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			preOrderRec(root.left);
			preOrderRec(root.right);
		}
	}

	public void inOrderRec(TreeNode root) {
		if (root != null) {
			inOrderRec(root.left);
			System.out.print(root.val + " ");
			inOrderRec(root.right);
		}
	}

	public void postOrderRec(TreeNode root) {
		if (root != null) {
			postOrderRec(root.left);
			postOrderRec(root.right);
			System.out.print(root.val + " ");
		}
	}

	public void preOrder1(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
	}

	public void preOrder2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				System.out.print(root.val + " ");
				stack.push(root);
				root = root.left;
			}
			TreeNode temp = stack.pop();
			root = temp.right; 
		}
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode temp = stack.pop();
			System.out.print(temp.val + " ");
			root = temp.right;
		}
	}


	public void postOrder1(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			if (node.left != null)
				stack1.push(node.left);
			if (node.right != null)
				stack1.push(node.right);
			stack2.push(node);
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().val + " ");
		}
	}

	public void postOrder2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode h = root;
		TreeNode c = null;
		while (!stack.isEmpty()) {
			c = stack.peek();
			// c.right == null || h != c.right 是为了保证,当h此刻指向c.right时, c.left不会被重复计算
			if (c.left != null && h != c.left && (c.right == null || h != c.right)) {
				stack.push(c.left);
			} else if (c.right != null && h != c.right) {
				stack.push(c.right);
			} else {
				h = stack.pop();
				System.out.print(h.val + " ");
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
		BinaryTreeTraversal traversal = new BinaryTreeTraversal();
		traversal.postOrder1(root);
		System.out.println();
		traversal.postOrder2(root);
	}
}
