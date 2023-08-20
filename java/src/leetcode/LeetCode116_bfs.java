package leetcode;

import common.Node;

/**
 * @author jingxinwu
 * @date 2021-07-08 1:06 上午
 */
public class LeetCode116_bfs {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;

        while (cur != null) {
            Node head = cur;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.left;
            }
            cur = head.left;
        }
        return root;
    }

}