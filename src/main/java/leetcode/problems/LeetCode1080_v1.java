package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/26 21:30
 */
public class LeetCode1080_v1 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return checkSufficientLeaf(root, 0, limit);
    }

    public TreeNode checkSufficientLeaf(TreeNode root, int sum, int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum < limit ? null : root;
        }
        root.left = checkSufficientLeaf(root.left, sum + root.val, limit);
        root.right = checkSufficientLeaf(root.right, sum + root.val, limit);
        return root.left == null && root.right == null ? null : root;
    }
}
