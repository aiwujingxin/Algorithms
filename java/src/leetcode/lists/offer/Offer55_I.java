package leetcode.lists.offer;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 02:11
 */
public class Offer55_I {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
