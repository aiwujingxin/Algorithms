package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/23 17:21
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
