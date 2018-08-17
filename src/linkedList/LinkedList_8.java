package linkedList;

public class LinkedList_8 {

    public RandNode copy(RandNode head) {
        if (head == null) {
            return null;
        }
        RandNode p = head;
        while (p != null) {
            RandNode next = p.next;
            RandNode temp = new RandNode(p.val);
            p.next = temp;
            temp.next = next;
            p = next;
        }
        p = head;
        while (p != null) {
            RandNode next = p.next.next;
            RandNode rand = p.rand.next;
            p.next.rand = rand;
            p = next;
        }
        RandNode mockHead = new RandNode(0);
        RandNode p2 = mockHead;
        p = head;
        while (p != null) {
            RandNode next = p.next.next;
            p2.next = p.next;
            p2 = p2.next;
            p.next = next;
            p = next;
        }
        return mockHead.next;
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
