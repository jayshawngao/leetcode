package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import algorithm.TreeNode;




/**
 * 二叉树的序列化和反序列化
* @ClassName: BinaryTreeSerialization
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Jayshawn
* @date 2018年1月6日 上午9:41:36
*
 */
public class BinaryTreeSerialization {
	
	// 序列化内部类
	static class Serialization{
		// 先序
		public String preOrder(TreeNode root){
				StringBuilder sb = new StringBuilder();
				if(root==null){
					sb.append("#!");
					return sb.toString();
				}else{
					sb.append(root.val+"!");
				}
				sb.append(preOrder(root.left));
				sb.append(preOrder(root.right));
				return sb.toString();
		}
		
		// 按行遍历
		public String breadth(TreeNode root){
			StringBuilder sb = new StringBuilder();
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.remove();
				if(node==null){
					sb.append("#!");
				}else{
					sb.append(node.val+"!");
					queue.add(node.left);
					queue.add(node.right);
				}
			}
			return sb.toString();
		}
		
	}
	
	// 反序列化内部类
	static class Deserialization{
		String[] vals;
		int index = -1;
		
		// 先序
		public TreeNode preOrder(String s){
			if(vals==null) vals = s.split("!");
			index++;
			TreeNode root = null;
			if(!vals[index].equals("#")){
				root = new TreeNode(Integer.valueOf(vals[index]));
				root.left = preOrder(s);
				root.right = preOrder(s);
			}
			return root;
			
		}
		
		// 按行遍历
		public TreeNode breadth(String s){
			if(vals==null) vals = s.split("!");
			Queue<TreeNode> queue = new LinkedList<>();
			index++;
			TreeNode root = new TreeNode(Integer.valueOf(vals[index]));
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode node = queue.remove();
				if(!vals[++index].equals("#")){
					TreeNode temp = new TreeNode(Integer.valueOf(vals[index]));
					node.left = temp;
					queue.add(temp);
				}
				if(!vals[++index].equals("#")){
					TreeNode temp = new TreeNode(Integer.valueOf(vals[index]));
					node.right = temp;
					queue.add(temp);
				}
			}
			return root;
		}
	}
	
	
	
	public static void main(String[] args) {
//		String tree = "12!3!#!#!#!";
//		TreeNode root = new Deserialization().preOrder(tree);
//		String tree2 = new Serialization().preOrder(root);
//		System.out.println(tree.equals(tree2));
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		String temp  = new Serialization().breadth(root);
		TreeNode root2 = new Deserialization().breadth(temp);
		System.out.println(root2.right.right.val);
	}
}
