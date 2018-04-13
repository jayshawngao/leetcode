package linkedList;

import java.util.Stack;

public class LinkedList_5 {

	public Node reverse(Node root, int k) {
		Node newHead = null;
		Node tail = null; // 指向新链表的尾节点  (1)用于当前翻转组内节点的连接, (2)记录下一个翻转区域的上一个节点, 用于连接两个翻转区域
		int size = 0; // 链表长度
		Node p = root; // 原链表全局遍历指针
		Stack<Node> stack = new Stack<>();
		while (p != null) {
			size++;
			p = p.next;
		}
		p = root; //将p重新指向root;
		if (size < k)
			return root;
		int count = size / k; // 有几个待翻转区域

		// 先处理第一组, 因为第一组的头节点比较特殊, 没有前置节点
		for (int i = 0; i < k; i++) {
			stack.push(p);
			p = p.next; // 循环过后, p指向的应该是当前翻转组的下一个节点
		}
		while (!stack.isEmpty()) {
			if (newHead == null) {
				newHead = stack.pop();
				tail = newHead;
			} else {
				tail.next = stack.pop();
				tail = tail.next;
			}
		}
		// 第一组处理完毕

		// 开始处理剩余的组
		for (int i = 1; i < count; i++) {
			for (int j = 0; j < k; j++) {
				stack.push(p);
				p = p.next; // 循环过后, p指向的应该是当前翻转组的下一个节点
			}
			while (!stack.isEmpty()) {
				tail.next = stack.pop();
				tail = tail.next;
			}
		}

		// 如果最后有剩余元素未成组, 在这里连接上它们
		tail.next = p;

		return newHead;

	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node p = root;
		p.next = new Node(2);
		p = p.next;
		p.next = new Node(3);
		p = p.next;
		p.next = new Node(4);
		p = p.next;
		p.next = new Node(5);
		p = p.next;
		p.next = new Node(6);
		p = p.next;
		p.next = new Node(7);
		p = p.next;
		p.next = new Node(8);
		root = new LinkedList_5().reverse(root, 3);
		System.out.println(root);
	}
}
