package linkedList;

import java.util.Stack;

public class LinkedList_7 {

	// 方法二 空间复杂度为O(1)
	public boolean isPalindrome(Node head){
		Node slow = head;
		Node quick = head;
		boolean odd = true; //节点数的奇偶
		Stack<Node> stack = new Stack<>();
		while(quick!=null){
			if(quick.next==null){ 
				odd = true; // 如果往后一步就是null, 说明是奇数个节点
			}else if(quick.next.next==null){
				odd = false; // 如果往后两步才是null, 说明是偶数个节点
			}
			stack.push(slow);
			slow = slow.next; //循环结束后, slow会指向中间节点的下一个节点
			if(quick.next==null) break; //这里特别注意, 直接quick.next.next会导致空指针异常
			quick = quick.next.next;
		}
		if (odd) {
			stack.pop();
		}
		while(!stack.isEmpty()){
			if(slow.val!=stack.pop().val)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	// 方法三 空间复杂度为O(1)
	public boolean isPalindrome2(Node head){
		boolean result = true;
		Node slow = head;
		Node mid = null;
		Node tail = null;
		Node quick = head;
		while(quick!=null){
			mid = slow; //循环结束后, slow会指向中间节点的下一个节点
			slow = slow.next;
			if(quick.next == null){
				break;
			}
			quick = quick.next.next;
		}
		Node p = mid; //相当于slow之前的一个节点
		while(slow!=null){
			Node temp = slow.next; //先记录下slow之后的节点
			slow.next = p; //改变当前slow的next指针为前一个节点
			p = slow; // p后移 , 循环结束指向尾节点
			slow = temp; // slow后移
		}
		tail = p; //记录下尾节点
		
		while(head!=mid){
			if(head.val!=p.val)
				result = false;
			head = head.next;
			p = p.next;
		}
		
		// 下面恢复节点间的指针为正确的方向
		slow = tail;
		p = null; // 现在的p代表slow的后一个节点, 这里的前后都是对于原链表来说
		while(slow!=mid){
			Node temp = slow.next; //先记录下slow的前一个节点
			slow.next = p; // 改变当前slow的next指针为下一个节点
			p = slow; // p前移
			slow = temp; // slow前移
		}
		
		return result;
		
		

		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		Node p = root;
		p.next = new Node(3);
		p = p.next;
		p.next = new Node(5);
		p = p.next;
		p.next = new Node(3);
		p = p.next;
		p.next = new Node(1);
		System.out.println(new LinkedList_7().isPalindrome2(root));
		System.out.println(root);
	}
}
