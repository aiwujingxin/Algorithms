package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 14:51
 */
public class LeetCode116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node nextHead = cur.left;
            while (cur != null && cur.left != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            cur = nextHead;
        }
        return root;
    }
}
