package linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedList_3 {

	// 使用辅助数据结构的解法
	public Node judge(Node root ,int num){
		List<Integer> list = new ArrayList<>();
		Node p = root;
		while(p!=null){
			list.add(p.val);
			p = p.next;
		}
		quickSort(list, num);
		root = new Node(list.get(0));
		p = root;
		for(int i=1;i<list.size();i++){
			p.next = new Node(list.get(i));
			p = p.next;
		}
		return root;
		
	}
	public void quickSort(List<Integer> list, int num){
		int i = -1; // 小于num区
		int j = list.size(); //大于num区
		for(int k=0;k<j;k++){ //注意这里小于j, 而不是list.size()
			if(list.get(k)<num){
				Collections.swap(list, ++i, k);
			}
			if(list.get(k)>num){
				Collections.swap(list, --j, k);
				k--;
			}
		}
	}
	
	// 不使用辅助数据结构的解法
	public Node judge2(Node root, int num){
		Node a = null; //指向小于num的链表的头
		Node b = null; //指向等于num的链表的头
		Node c = null; //指向大于num的链表的头
		
		Node ap = null;
		Node bp = null;
		Node cp = null;
		
		int countA = 0;
		int countB = 0;
		int countC = 0;
		
		while(root!=null){
			if(root.val<num){
				if(a==null){
					a = root;
					ap = a;
				}else{
					ap.next = root;
					ap = ap.next;
				}
				countA++;
			}else if(root.val==num){
				if(b==null){
					b = root;
					bp = b;
				}else{
					bp.next = root;
					bp = bp.next;
				}
				countB++;
			}else{
				if(c==null){
					c = root;
					cp = c;
				}else{
					cp.next = root;
					cp = cp.next;
				}
				countC++;
			}
			root = root.next;
		}
		
		Node head = new Node(0);
		Node p = head;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		while(countA-->0){
			p.next = a;
			p = p.next;
			a = a.next;
			
		}
		while(countB-->0){
			p.next = b;
			p = p.next;
			b = b.next;
		}
		while(countC-->0){
			p.next = c;
			p = p.next;
			c = c.next;
		}
		return head.next;
		
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		Node p = root;
		p.next = new Node(2);
		p = p.next;
		p.next = new Node(10);
		p = p.next;
		p.next = new Node(6);
		p = p.next;
		p.next = new Node(8);
		root = new LinkedList_3().judge2(root, 7);
		System.out.println(root);
	}
}
