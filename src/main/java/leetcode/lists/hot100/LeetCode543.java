package leetcode.lists.hot100;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/8 12:49
 * {@link LeetCode124}
 * {@link leetcode.problems.LeetCode687}
 * {@link leetcode.problems.LeetCode549_dp_tree}
 */
public class LeetCode543 {

    // 记录最大直径的长度
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}