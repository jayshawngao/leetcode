package stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import algorithm.TreeNode;

public class Saq_6 {

// 有问题,问题在于只能确定父亲, 不能确定左孩子还是右孩子
//	// 利用栈实现, 栈中存放的是下标
//	public TreeNode maxTree(int[] a){
//		int[] left = new int[a.length]; //存放的是下标
//		int[] right = new int[a.length];
//		Stack<Integer> stack = new Stack<>();
//		for(int i=0;i<a.length;i++){
//			while(!stack.isEmpty()&&a[stack.peek()]<=a[i])
//				stack.pop();
//			if(stack.isEmpty()){
//				left[i]=-1;
//			}else{
//				left[i]=stack.peek();
//				stack.push(i);
//			}
//		}
//		stack.clear();
//		for(int i=a.length-1;i>=0;i--){
//			while(!stack.isEmpty()&&a[stack.peek()]<=a[i])
//				stack.pop();
//			if(stack.isEmpty()){
//				right[i]=-1;
//			}else{
//				right[i]=stack.peek();
//				stack.push(i);
//			}
//		}
//		TreeNode[] nodes = new TreeNode[a.length];
//		for(int i=0;i<a.length;i++){
//			nodes[i] = new TreeNode(a[i]);
//		}
//		for(int i=0;i<a.length;i++){
//			int leftMax = left[i];
//			int rightMax = right[i];
//			if(leftMax==-1&&rightMax==-1){
//				continue;
//			}else if(leftMax==-1){
//				
//			}
//		}
//	}
//	

	// 先构造大根堆, 然后进行按层次遍历, 反序列化出一棵树, 因为是满二叉树, 所以不需要特殊标记来标记null节点
	public TreeNode maxTree2(int[] a) {
		buildTree(a);
		return deserialiaze(a);
		
	}
	
	
	public TreeNode deserialiaze(int[] a){
		TreeNode root = new TreeNode(a[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int i=0;
		while(i<a.length){
			TreeNode node = queue.poll();
			if(++i<a.length){
				node.left=new TreeNode(a[i]);
				queue.offer(node.left);
			}
			if(++i<a.length){
				node.right=new TreeNode(a[i]);
				queue.offer(node.right);
			}
		}
		return root;
		
	}

	public void buildTree(int[] a) {
		for (int i = (a.length - 2) / 2; i >= 0; i--) {
			adjust(a, i, a.length);
		}

	}

	public void adjust(int[] a, int p, int length) {
		int temp = a[p];
		for (int i = 2 * p + 1; i < length; i = 2 * i + 1) {
			if (i + 1 < length && a[i + 1] > a[i]) {
				i++;
			}
			if (temp >= a[i])
				break;
			else {
				a[p] = a[i];
				p = i;
			}
		}
		a[p] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{3,4,5,1,2};
		Saq_6 saq_6 = new Saq_6();
		TreeNode root = saq_6.maxTree2(a);
		System.out.println(root.right.val);
	}
}
