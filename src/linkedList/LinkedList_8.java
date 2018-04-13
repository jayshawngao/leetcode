package linkedList;

public class LinkedList_8 {

	public RandNode copy(RandNode head){
		RandNode p = head;
		if(p==null) 
			return head;
		while(p!=null){
			 RandNode next = p.next;
			RandNode temp = new RandNode(p.val);
			temp.next = p.next;
			p.next = temp;
			p = next;
		}
		p = head;
		while(p!=null){
			p.next.rand = p.rand.next;
			p = p.next.next;
		}
		
		RandNode newHead = null; //新头
		RandNode newP = null; //用于遍历新链表
		p = head; // 用于遍历原链表
		RandNode pre = null; // p的前一位
		int check = 0; // 用于判断是否是新节点
		while(p!=null){
			if(check++%2==1){
				if(newHead==null){
					newHead = p;
					newP = p;
				}else{
					newP.next = p;
					newP = newP.next;
				}
				pre.next = p.next; // 删除p
			}
			pre = p;
			p = p.next;
			
		}
		return newHead;
		
	}
	public static void main(String[] args) {
		RandNode head = new RandNode(1);
		head.next = new RandNode(2);
		head.next.next = new RandNode(3);
		head.rand = head.next.next;
		head.next.rand = head;
		head.next.next.rand = head.next;
		System.out.println(new LinkedList_8().copy(head));
		System.out.println(head);
	}
}
