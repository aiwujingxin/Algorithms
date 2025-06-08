package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:46
 */
public class LeetCode111 {

    public int minDepth(TreeNode r) {
        if (r == null) return 0;
        if (r.left == null) return 1 + minDepth(r.right);
        if (r.right == null) return 1 + minDepth(r.left);
        return 1 + Math.min(minDepth(r.left), minDepth(r.right));
    }
}
