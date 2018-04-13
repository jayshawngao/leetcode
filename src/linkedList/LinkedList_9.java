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
		Node slow = head;
		Node quick = head;
		while (quick != null) {
			slow = slow.next;
			if (quick.next == null) {
				quick = null;
				break;
			} else {
				quick = quick.next.next;
			}
			if (slow == quick) {
				break;
			}
			
		}
		if(quick==null){
			return null;
		}else{
			quick = head;
			slow = slow.next; // slow也要前进一个否则答案不对的
			while(slow!=quick){
				slow = slow.next;
				quick = quick.next.next;
			}
		}
		return slow;
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
