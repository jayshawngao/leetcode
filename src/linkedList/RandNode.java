package linkedList;

public class RandNode {

	// 随机指向一个节点
	public RandNode rand;
	public int val;
	public RandNode next;
	
	public RandNode(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		RandNode node = this;
		while(node!=null){
			sb.append(node.val+"->");
			node = node.next;
		}
		return sb.toString().substring(0, sb.length()-2);
	}


	
}
