package leetcode.lists.offer;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-11-25 12:33 上午
 */
public class Offer55_1 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
