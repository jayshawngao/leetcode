package linkedList;

public class Node {

	int val;
	Node next;
	public Node(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(val+"->");
		Node temp = this.next;
		while(temp!=null&&temp!=this){
			sb.append(temp.val+"->");
			temp = temp.next;
		}
		return sb.toString().substring(0, sb.length()-2);
	}
}
