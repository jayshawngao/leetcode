package linkedList;

import java.util.HashMap;

public class LinkedList_9 {

	// 使用HashMap 空间复杂度为O(n)
	public Node isLoop(Node head) {
		HashMap<Node, Integer> map = new HashMap<>();
		while (head != null) {
			if (map.containsKey(head)) {
				return head;
			} else {
				map.put(head, 1);
			}
			head = head.next;

		}
		return null;
	}

	public Node isLoop2(Node head) {
		if (head == null) {
			return null;
		}
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	

	public static void main(String[] args) {
		Node root = new Node(2);
		Node p = root;
		p.next = new Node(4);
		p = p.next;
		p.next = new Node(6);
		p = p.next;
		p.next = new Node(8);
		p = p.next;
		p.next = new Node(10);
		p = p.next;
		p.next = root.next.next;
		System.out.println(new LinkedList_9().isLoop2(root).val);
	}
}
