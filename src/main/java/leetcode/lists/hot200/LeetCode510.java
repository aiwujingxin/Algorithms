package leetcode.lists.hot200;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/14 11:15
 */
public class LeetCode510 {

    public Node inorderSuccessor(Node x) {
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }
        while (x.parent != null && x == x.parent.right) {
            x = x.parent;
        }
        return x.parent;
    }
}
