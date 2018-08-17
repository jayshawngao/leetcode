package linkedList;

public class LinkedList_6 {

    public Node delete(Node head, int val) {
        Node cur = head; // 遍历当前链表
        Node newHead = new Node(0); //待返回的新链表
        Node tail = newHead; //用于记录新链表的末尾

        while (cur != null) {
            if (cur.val != val) {
                tail.next = cur;
                tail = tail.next;
            }
            cur = cur.next;
        }
        tail.next = null; //切断新链表最后一个元素与原链表的关联, 比如, 原链表最后一个节点恰好等于num, 并且前一个节点加入了新链表, 循环直接跳过, 但是链接还是存在于前一个节点
        return newHead.next;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        Node p = root;
        p.next = new Node(4);
        p = p.next;
        p.next = new Node(6);
        p = p.next;
        p.next = new Node(7);
        p = p.next;
        p.next = new Node(8);
        root = new LinkedList_6().delete(root, 8);
        System.out.println(root);
    }
}
