package leetcode.hot100;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 00:47
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
