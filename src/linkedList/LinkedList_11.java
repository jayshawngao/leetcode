package linkedList;

public class LinkedList_11 {

	public Node isCross(Node head1, Node head2){
		Node loopStart1 = findLoopStart(head1);
		Node loopStart2 = findLoopStart(head2);
		Node p1 = head1;
		Node p2 = head2;
		if(loopStart1==loopStart2){
			int len1 = lenBeforeLoop(head1, loopStart1);
			int len2 = lenBeforeLoop(head2, loopStart2);
			int step = 0;
			if(len1>len2){
				step = len1-len2;
				while(step>0){
					p1 = p1.next;
				}
			}
			if(len1<len2){
				step = len2-len1;
				while(step>0){
					p2 = p2.next;
				}
			}
			while(p1!=p2){
				p1 = p1.next;
				p2 = p2.next;
			}
			return p1;
		}else{
			p1 = loopStart1.next;
			while(p1!=loopStart1){
				if(p1==loopStart2){
					return loopStart1;
				}
			}
			return null;
		}
		
	}
	
	public Node findLoopStart(Node head){
		Node slow = head;
		Node quick = head;
		while(slow!=quick){
			slow = slow.next;
			quick = quick.next.next;
		}
		quick = head;
		slow = slow.next;
		while(quick!=slow){
			slow = slow.next;
			quick = quick.next.next;
		}
		return quick;
	}
	
	// 循环之前的长度, 包含循环入口节点 
	public int lenBeforeLoop(Node head, Node loopStart){
		int size = 0;
		while(head!=loopStart){
			size++;
			head = head.next;
		}
		return ++size;
	}
}
