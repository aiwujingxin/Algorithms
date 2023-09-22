package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 23:34
 */
public class LeetCode437 {

    int res;

    public int pathSum(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        dfs(root, target);

        pathSum(root.left, target);
        pathSum(root.right, target);
        return res;
    }

    private void dfs(TreeNode root, long target) {
        if (root == null) {
            return;
        }
        if (target == root.val) {
            res++;
        }
        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
    }
}
