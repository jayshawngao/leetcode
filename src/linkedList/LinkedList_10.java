package linkedList;

public class LinkedList_10 {

    public Node isCross(Node head1, Node head2) {
        int len1 = 0;
        int len2 = 0;
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        p1 = head1;
        p2 = head2;
        if (len1 > len2) {
            int step = len1 - len2;
            while (step-- > 0) {
                p1 = p1.next;
            }
        } else if (len2 > len1) {
            int step = len2 - len1;
            while (step-- > 0) {
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;

    }

    public static void main(String[] args) {
        Node cross = null;
        Node head1 = new Node(1);
        Node p1 = head1;
        p1.next = new Node(2);
        p1 = p1.next;
        p1.next = new Node(3);
        p1 = p1.next;
        cross = p1;
        p1.next = new Node(4);

        Node head2 = new Node(7);
        Node p2 = head2;
        p2.next = new Node(6);
        p2 = p2.next;
        p2.next = cross;
        p2 = p2.next;
        p2.next = cross.next;

        System.out.println(new LinkedList_10().isCross(head1, head2).val);

    }
}
