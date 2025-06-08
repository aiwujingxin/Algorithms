package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:55
 */
public class LeetCode116 {

    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node dummy = new Node();
            Node cur = dummy;
            while (head != null) {
                if (head.left != null) {
                    cur.next = head.left;
                    cur = cur.next;
                }
                if (head.right != null) {
                    cur.next = head.right;
                    cur = cur.next;
                }
                head = head.next;
            }
            head = dummy.next;
        }
        return root;
    }
}
