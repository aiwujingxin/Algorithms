package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 17:43
 * {@link LeetCode1110_dfs}
 */
public class LeetCode1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return checkSufficientLeaf(root, 0, limit) ? root : null;
    }

    public boolean checkSufficientLeaf(TreeNode node, int sum, int limit) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return node.val + sum >= limit;
        }

        boolean left = checkSufficientLeaf(node.left, sum + node.val, limit);
        boolean right = checkSufficientLeaf(node.right, sum + node.val, limit);

        if (!left) {
            node.left = null;
        }
        if (!right) {
            node.right = null;
        }
        return left || right;
    }

}
