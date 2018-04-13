package linkedList;

public class LinkedList_2 {

	public void delete(Node deleted){
		Node next = deleted.next;
		if(next==null){
			deleted=null;
		}else{
			deleted.val = next.val;
			deleted.next = next.next;
		}
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
		System.out.println(root);
		new LinkedList_2().delete(root.next.next);
		System.out.println(root);
	}
}
