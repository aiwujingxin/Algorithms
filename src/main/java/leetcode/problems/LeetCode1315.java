package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 18:00
 */
public class LeetCode1315 {

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, 0);
        return sum;
    }

    public void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            dfs(root, depth, depth + 2);
        }
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

    public void dfs(TreeNode root, int depth, int target) {
        if (root == null) {
            return;
        }
        if (depth > target) {
            return;
        }
        if (depth == target) {
            sum += root.val;
        }
        dfs(root.left, depth + 1, target);
        dfs(root.right, depth + 1, target);
    }

}
