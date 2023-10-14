package leetcode.lists.lcr;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:55
 */
public class LCR50 {
    int res;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (targetSum == root.val) {
            res++;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }
}
