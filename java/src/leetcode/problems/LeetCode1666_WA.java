package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/24 22:45
 */
public class LeetCode1666_WA {

    public Node flipBinaryTree(Node root, Node leaf) {
        Node cur = leaf;
        while (cur != null) {
            if (cur == leaf) {
                Node p = cur.parent;
                Node pp = p.parent;
                if (p.left == leaf) {
                    p.left = pp;
                    cur.left = p;
                } else if (p.right == leaf) {
                    Node pl = p.left;
                    Node pr = pl.right;
                    pl.right = pl;
                    pr.left = p;
                }
                cur = p;
            } else {
                Node p = cur.parent;
                Node pl = p.left;
                Node pp = p.parent;
                p.right = pl;
                p.left = pp;
                cur.left = p;
                cur = pp;
            }
        }
        return leaf;
    }
}
