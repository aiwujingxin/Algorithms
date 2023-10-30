package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/30 16:22
 */
public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node head = null;
        Node pre = null;
        Node cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        pre = cur.left;
                        head = cur.left;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        pre = cur.right;
                        head = cur.right;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
        return root;
    }
}
