package linkedList;

public class LinkedList_4 {

	public void print(Node node1, Node node2){
		while(node1!=null&&node2!=null){
			if(node1.val==node2.val){
				System.out.println(node1.val);
				node1 = node1.next;
				node2  =node2.next;
			}else if(node1.val>node2.val){
				node2 = node2.next;
			}else{
				node1 = node1.next;
			}
		}
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(2);
		Node p = root1;
		p.next = new Node(4);
		p = p.next;
		p.next = new Node(6);
		p = p.next;
		p.next = new Node(8);
		p = p.next;
		p.next = new Node(10);
		
		Node root2 = new Node(1);
		p = root2;
		p.next = new Node(3);
		p = p.next;
		p.next = new Node(6);
		p = p.next;
		p.next = new Node(8);
		p = p.next;
		p.next = new Node(11);
		new LinkedList_4().print(root1, root2);
	}
}
