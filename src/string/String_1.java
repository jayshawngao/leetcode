package string;

import algorithm.TreeNode;

public class String_1 {

	public String serialize(TreeNode root){
		StringBuilder sb = new StringBuilder();
		if(root==null){
			sb.append("#!");
		}else{
			sb.append(root.val+"!");
			sb.append(serialize(root.left));
			sb.append(serialize(root.right));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String_1 string_1 = new String_1();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(7);
		root2.right= new TreeNode(8);
		String s1 = string_1.serialize(root);
		String s2 = string_1.serialize(root2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(new KMP().kmp(s1, s2));
		
	}
}
