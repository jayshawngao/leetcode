package linkedList;


public class LinkedList_1 {

    public Node insert(Node root, int val) {
        Node node = new Node(val);
        if (root == null) {
            node.next = node;
            return node;
        }
        Node pre = root;
        Node cur = root.next;
        while (cur != root) {
            if (pre.val <= val && val <= cur.val) {
                pre.next = node;
                node.next = cur;
                return root;
            }
            pre = pre.next;
            cur = cur.next;
        }
        // 如果上面的while循环后仍没有找到插入位置
        pre.next = node;
        node.next = cur;
        return val <= root.val ? node : root;
    }


    public static void main(String[] args) {
        Node root = new Node(2);
        root.next = root;
        Node p = root;
        p.next = new Node(4);
        p = p.next;
        p.next = new Node(6);
        p = p.next;
        p.next = new Node(8);
        p = p.next;
        p.next = new Node(10);
        p = p.next;
        p.next = root;
        root = new LinkedList_1().insert(root, 11);

        System.out.println(root);

    }
}
