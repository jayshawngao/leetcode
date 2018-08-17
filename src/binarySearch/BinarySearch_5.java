package binarySearch;

import algorithm.TreeNode;

public class BinarySearch_5 {

    // 返回一棵完全二叉树的节点数
    public int cac(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        int leftH = 0;
        int rightH = 0;
        TreeNode p = root;
        while (p != null) {
            leftH++;
            p = p.left;
        }
        p = root;
        if (p != null) {
            rightH++;
            p = p.right;
            while (p != null) {
                rightH++;
                p = p.left;
            }
        }
        if (leftH == rightH) {
            res += Math.pow(2, leftH - 1) - 1 + cac(root.right) + 1; //最后的+1是根节点
        } else {
            res += Math.pow(2, rightH - 1) - 1 + cac(root.left) + 1; // 最后的+1是根节点
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new BinarySearch_5().cac(root));
    }
}
