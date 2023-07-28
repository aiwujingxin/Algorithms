package leetcode.lists.topinterview;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 17:56
 */
public class LeetCode104 {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }
}
