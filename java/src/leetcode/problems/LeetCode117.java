package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/25 18:20
 */
public class LeetCode117 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node nextHead = new Node();
            Node nextCur = nextHead;
            while (cur != null) {
                if (cur.left != null) {
                    nextCur.next = cur.left;
                    nextCur = nextCur.next;
                }
                if (cur.right != null) {
                    nextCur.next = cur.right;
                    nextCur = nextCur.next;
                }
                cur = cur.next;
            }
            cur = nextHead.next;
        }
        return root;
    }
}
