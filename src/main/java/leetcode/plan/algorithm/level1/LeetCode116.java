package leetcode.plan.algorithm.level1;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 22:22
 */
public class LeetCode116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node head = root;
        while (root.left != null) {
            Node next = root.left;
            Node cur = root;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                } else {
                    cur.right.next = null;
                }
                cur = cur.next;
            }
            root = next;
        }

        return head;
    }
}
