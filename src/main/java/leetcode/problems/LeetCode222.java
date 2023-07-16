package leetcode.problems;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-08-24 11:54 下午
 */
public class LeetCode222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right) {
            return (1 << left) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    private int leftDepth(TreeNode root) {
        int cnt = 0;

        while (root != null) {
            root = root.left;
            cnt++;
        }
        return cnt;
    }

    private int rightDepth(TreeNode root) {
        int cnt = 0;
        while (root != null) {
            root = root.right;
            cnt++;
        }
        return cnt;
    }

}
