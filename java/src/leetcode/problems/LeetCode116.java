package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/25 18:11
 */
public class LeetCode116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node nextHead = cur.left;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null) {
                    cur.right.next = cur.next == null ? null : cur.next.left;
                }
                cur = cur.next;
            }
            cur = nextHead;
        }
        return root;
    }
}
