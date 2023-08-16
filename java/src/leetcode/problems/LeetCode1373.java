package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 15:01
 */
public class LeetCode1373 {

    int result = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {

        if (root.left == null && root.right == null) {
            if (result < root.val) result = root.val;
            return root.val;
        }

        if (root.left == null) {

            int rSum = dfs(root.right);
            if (root.right.val != Integer.MIN_VALUE && root.val < getMin(root.right)) {
                int sum = rSum + root.val;
                if (sum > result) result = sum;
                return sum;
            }

            root.val = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        if (root.right == null) {

            int lSum = dfs(root.left);
            if (root.left.val != Integer.MIN_VALUE && root.val > getMax(root.left)) {
                int sum = lSum + root.val;
                if (sum > result) result = sum;
                return sum;
            }

            root.val = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        int lSum = dfs(root.left);
        int rSum = dfs(root.right);

        if (root.left.val == Integer.MIN_VALUE || root.right.val == Integer.MIN_VALUE) {
            root.val = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        int maxL = getMax(root.left);
        int minR = getMin(root.right);

        if (maxL < root.val && root.val < minR) {
            int sum = lSum + rSum + root.val;
            if (sum > result) result = sum;
            return sum;
        }

        root.val = Integer.MIN_VALUE;
        return Integer.MIN_VALUE;
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        while (root.right != null)
            root = root.right;
        return root.val;

    }

    private int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        while (root.left != null)
            root = root.left;
        return root.val;
    }
}
